package com.team10.user.controller;

import com.alibaba.druid.util.StringUtils;
import com.team10.annotation.TokenCheck;
import com.team10.enums.ReturnCode;
import com.team10.annotation.CarLog;
import com.team10.user.dto.AddrDto;
import com.team10.user.model.Address;
import com.team10.user.response.*;
import com.team10.user.service.AddressService;
import com.team10.user.service.UserService;
import com.team10.util.TokenUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author LINZHIPIN
 * @CreateTime 2021/07/07/00007 0:58:42
 */
@RestController
public class UserController {
    @Autowired
    private Environment env;
    @Autowired
    private UserService userService;
    @Autowired
    private AddressService addressService;

    @CarLog
    @TokenCheck
    @RequestMapping("/index")
    public String index() {
        return "/user/index";
    }


    @RequestMapping("/")
    public String index1() {
        return "index";
    }

    //跳到登录页
    //@CarLog
    @RequestMapping(value = {"/login", "/unauth"})
    public String toLogin() {
        return "/user/login";
    }

    //登录认证
    @CarLog
    @PostMapping("/user/login")
    public TokenResponse login(String username,String password, ModelMap modelMap, HttpServletResponse response) {
        String msg = "";
        int code = 1000;
        TokenResponse tokenResponse = new TokenResponse();
        try {
            if (!SecurityUtils.getSubject().isAuthenticated()) {
                //这个token是shiro的token，不是给前端的token
                UsernamePasswordToken token = new UsernamePasswordToken(username, password);
                SecurityUtils.getSubject().login(token);
            }
        } catch (UnknownAccountException e) {
            //此处用户名不存在转入注册界面
            msg = e.getMessage();
            code = ReturnCode.NO_ACCOUNT;
            modelMap.addAttribute("userName", username);
        } catch (DisabledAccountException e) {
            msg = e.getMessage();
            code = ReturnCode.ILLEGAL_ACCOUNT;
            modelMap.addAttribute("userName", username);
        } catch (IncorrectCredentialsException e) {
            msg = e.getMessage();
            code = ReturnCode.WRONG_PASS;
            modelMap.addAttribute("userName", username);
        }

        if (StringUtils.isEmpty(msg)) {
            msg = "操作成功";
            tokenResponse.setToken(TokenUtils.getToken(username, password, userService.getUser(username).getUserId()));
        }
        tokenResponse.setMsg(msg);
        tokenResponse.setCode(code);
        return tokenResponse;
    }

    //退出登录
    //由于JWT的一次签发永久有效，只好让前台删除token来解决登出问题
    @CarLog
    @PostMapping(value = "/user/logout")
    @TokenCheck
    //TODO
    public NoTokenResponse logout() {
        NoTokenResponse response = new NoTokenResponse();
        String msg = "操作失败";
        int code = ReturnCode.UNKNOWN_ERROR;
        if (TokenUtils.checkToken()) {
            msg = "操作成功";
            SecurityUtils.getSubject().logout();
            code = ReturnCode.SUCCESS;
        }
        response.setMsg(msg);
        response.setCode(code);
        return response;
    }

    //用户注册
    @CarLog
    @PostMapping("/user/register")
    public TokenResponse registry(String username, String password) {
        TokenResponse response = new TokenResponse();
        String msg = "操作失败";
        int code = ReturnCode.UNKNOWN_ERROR;
        if (userService.addUser(username, password)) {
            msg = "操作成功";
            code = ReturnCode.SUCCESS;
            response.setToken(TokenUtils.getToken(username, password, userService.getUser(username).getUserId()));
        }
        response.setMsg(msg);
        response.setCode(code);
        return response;
    }

    //获取用户的收货地址
    @CarLog
    @GetMapping("/user/userReceiveAddrs")
    @TokenCheck
    public AddrResponse userReceiveAddrs() {
        AddrResponse response = new AddrResponse();
        //TODO
        String msg = "操作成功";
        int code = ReturnCode.SUCCESS;
        List<AddrDto> list = addressService.getAddrs(TokenUtils.getUserId());
        if (list.isEmpty()) {
            msg = "操作失败";
            code = ReturnCode.UNKNOWN_ERROR;
        }
        response.setCode(code);
        response.setList(list);
        response.setMsg(msg);
        return response;
    }

    //获取用户订单列表
    @CarLog
    @GetMapping("/user/userOrderList")
    @TokenCheck
    public OrderResponse userOrderList() {
        OrderResponse response = new OrderResponse();
        //TODO
        String msg = "操作成功";
        int code = ReturnCode.SUCCESS;
//        List<OrderDto> list = OrderService.getOrderDto(TokenUtils.getUserId());
//        response.setCode(code);
//        response.setList(list);
//        response.setMsg(msg);
        return response;
    }

    //用户新增一个收货地址
    @CarLog
    @PostMapping("/user/addUserReceiveAddrs")
    @TokenCheck
    public NoTokenResponse addAddrs(String name,String phone,
                                    String addr) {
        NoTokenResponse response = new NoTokenResponse();
        String msg = "操作失败";
        int code = ReturnCode.UNKNOWN_ERROR;
        if(addressService.addAddr(new Address(name, phone, addr,
                TokenUtils.getUserId()))){
            msg = "操作成功";
            code = ReturnCode.SUCCESS;
        }
        response.setCode(code);
        response.setMsg(msg);
        return response;
    }

    //用户修改收货地址
    @CarLog
    @PostMapping("/user/updateUserReceiveAddr")
    @TokenCheck
    public NoTokenResponse updateAddr(int id,String name,String phone,String addr) {
        NoTokenResponse response = new NoTokenResponse();
        String msg = "操作失败";
        int code = ReturnCode.UNKNOWN_ERROR;
        if(addressService.updateAddr(new Address(id,name,phone,addr))){
            msg = "操作成功";
            code = ReturnCode.SUCCESS;
        }
        response.setCode(code);
        response.setMsg(msg);
        return response;
    }

    //用户获取单个收货地址详细信息
    @CarLog
    @PostMapping("/user/getUserReceiveAddr")
    @TokenCheck
    public SingleReceiveResponse getAddr(int id) {
        SingleReceiveResponse response = new SingleReceiveResponse();
        //TODO
        String msg = "操作成功";
        int code = ReturnCode.SUCCESS;
        AddrDto addrDto = addressService.getAddr(id);
        response.setCode(code);
        response.setReceiveAddr(addrDto);
        response.setMsg(msg);
        return response;
    }
}
