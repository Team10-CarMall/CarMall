package com.team10.user.controller;

import com.alibaba.druid.util.StringUtils;
import com.team10.user.log.CarLog;
import com.team10.user.service.ControllerLogService;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author LINZHIPIN
 * @CreateTime 2021/07/07/00007 0:58:42
 */
@Controller
public class UserController {
    @Autowired
    private Environment env;
    @Autowired
    private ControllerLogService controllerLogService;

    @CarLog
    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        return "abc";
    }

    //跳到登录页
    @CarLog
    @RequestMapping(value = {"/to/login", "/unauth"})
    public String toLogin() {
        return "login";
    }

    //登录认证
    @CarLog
    @PostMapping("/login")
    public String login(@RequestParam String userName, @RequestParam String password, ModelMap modelMap) {
        String errorMsg = "";
        try {
            if (!SecurityUtils.getSubject().isAuthenticated()) {
                String newPsd = new Md5Hash(password, env.getProperty("shiro.encrypt.password.salt")).toString();
                UsernamePasswordToken token = new UsernamePasswordToken(userName, newPsd);
                SecurityUtils.getSubject().login(token);
            }
        } catch (UnknownAccountException e) {
            //此处用户名不存在转入注册界面
            errorMsg = e.getMessage();
            modelMap.addAttribute("userName", userName);
            return "registry";
        } catch (DisabledAccountException e) {
            errorMsg = e.getMessage();
            modelMap.addAttribute("userName", userName);
        } catch (IncorrectCredentialsException e) {
            errorMsg = e.getMessage();
            modelMap.addAttribute("userName", userName);
        } catch (Exception e) {
            errorMsg = "用户登录异常，请联系管理员!";
            e.printStackTrace();
        }
        if (StringUtils.isEmpty(errorMsg)) {
            return "redirect:/index";
        } else {
            modelMap.addAttribute("errorMsg", errorMsg);
            return "login";
        }
    }

    //退出登录
    @CarLog
    @RequestMapping(value = "/logout")
    public String logout() {
        SecurityUtils.getSubject().logout();
        return "login";
    }

    @CarLog
    @PostMapping("/registry")
    public String registry(@RequestParam String username,@RequestParam String password) {
        return null;
    }
}
