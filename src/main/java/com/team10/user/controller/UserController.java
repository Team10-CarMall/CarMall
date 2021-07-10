package com.team10.user.controller;

import com.alibaba.druid.util.StringUtils;
import com.team10.enumdemo.ReturnCode;
import com.team10.annotation.CarLog;
import com.team10.user.dto.AddrDto;
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
@Controller
public class UserController {
    @Autowired
    private Environment env;
    @Autowired
    private UserService userService;
    @Autowired
    private AddressService addressService;

    @CarLog
    @RequestMapping("/index")
    public String index() {
        return "/index";
    }


    //跳到登录页
    @CarLog
    @RequestMapping(value = {"/to/login", "/unauth"})
    public String toLogin() {
        return "/login";
    }

    //登录认证
    @CarLog
    @PostMapping("/user/login")
    @ResponseBody
    public TokenResponse login(@RequestParam String userName, @RequestParam String password, ModelMap modelMap, HttpServletResponse response) {
        String msg = "操作成功";
        int code = 1000;
        TokenResponse tokenResponse = new TokenResponse();
        try {
            if (!SecurityUtils.getSubject().isAuthenticated()) {
                String newPsd = new Md5Hash(password, env.getProperty("shiro.encrypt.password.salt")).toString();
                //这个token是shiro的token，不是给前端的token
                UsernamePasswordToken token = new UsernamePasswordToken(userName, newPsd);
                SecurityUtils.getSubject().login(token);
            }
        } catch (UnknownAccountException e) {
            //此处用户名不存在转入注册界面
            msg = e.getMessage();
            code = ReturnCode.NO_ACCOUNT;
            modelMap.addAttribute("userName", userName);
        } catch (DisabledAccountException e) {
            msg = e.getMessage();
            code = ReturnCode.ILLEGAL_ACCOUNT;
            modelMap.addAttribute("userName", userName);
        } catch (IncorrectCredentialsException e) {
            msg = e.getMessage();
            code = ReturnCode.WRONG_PASS;
            modelMap.addAttribute("userName", userName);
        } catch (Exception e) {
            msg = "用户登录异常，请联系管理员!";
            code = ReturnCode.UNKNOWN_ERROR;
            e.printStackTrace();
        }
        tokenResponse.setMsg(msg);
        tokenResponse.setCode(code);
        if (StringUtils.isEmpty(msg)) {
////          登录成功
//            //TODO
//            response.setHeader("token", TokenUtils.getToken(userName,password));
            tokenResponse.setToken(TokenUtils.getToken(userName, password, userService.getUserId(userName)));
            return tokenResponse;
        } else {
            return tokenResponse;
        }
    }

    //退出登录
    @CarLog
    @PostMapping(value = "/user/logout")
    @ResponseBody
    //TODO
    public NoTokenResponse logout(String token) {
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
    @ResponseBody
    public TokenResponse registry(@RequestParam String username, @RequestParam String password) {
        TokenResponse response = new TokenResponse();
        String msg = "操作失败";
        int code = ReturnCode.UNKNOWN_ERROR;
        if (userService.addUser(username, password)) {
            msg = "操作成功";
            code = ReturnCode.SUCCESS;
            response.setToken(TokenUtils.getToken(username, password, userService.getUserId(username)));
        }
        response.setMsg(msg);
        response.setCode(code);
        return response;
    }

    //获取用户的收货地址
    @CarLog
    @GetMapping("/user/userReceiveAddrs")
    @ResponseBody
    public AddrResponse userReceiveAddrs() {
        AddrResponse response = new AddrResponse();
        //TODO
        String msg = "操作成功";
        int code = ReturnCode.SUCCESS;
        List<AddrDto> list = addressService.getAddrs(TokenUtils.getUserId());
        response.setCode(code);
        response.setList(list);
        response.setMsg(msg);
        return response;
    }

    //获取用户订单列表
    @CarLog
    @GetMapping("/user/userOrderList")
    @ResponseBody
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
    @ResponseBody
    public NoTokenResponse addAddrs(String name,String phone,String addr) {
        NoTokenResponse response = new NoTokenResponse();
        String msg = "操作失败";
        int code = ReturnCode.UNKNOWN_ERROR;
        if(addressService.addAddr(name,phone,addr,TokenUtils.getUserId())){
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
    @ResponseBody
    public NoTokenResponse updateAddrs(String name,String phone,String addr) {
        NoTokenResponse response = new NoTokenResponse();
        String msg = "操作失败";
        int code = ReturnCode.UNKNOWN_ERROR;
        if(addressService.updateAddr(name,phone,addr,TokenUtils.getUserId())){
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
    @ResponseBody
    //用户获取单个收货地址详细信息
    public SingleReceiveResponse getAddr(int id) {
        SingleReceiveResponse response = new SingleReceiveResponse();
        //TODO
        String msg = "操作成功";
        int code = ReturnCode.SUCCESS;
        AddrDto addrDto = addressService.getAddr(TokenUtils.getUserId());
        response.setCode(code);
        response.setReceiveAddr(addrDto);
        response.setMsg(msg);
        return response;
    }


}
