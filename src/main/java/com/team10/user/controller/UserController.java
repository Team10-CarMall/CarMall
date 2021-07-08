package com.team10.user.controller;

import com.team10.user.log.CarLog;
import com.team10.user.model.ControllerLog;
import com.team10.user.service.ControllerLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author LINZHIPIN
 * @CreateTime 2021/07/07/00007 0:58:42
 */
@Controller
public class UserController {
    @Autowired
    private ControllerLogService controllerLogService;

    @CarLog
    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        return "abc";
    }
}
