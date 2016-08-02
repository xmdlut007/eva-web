package com.cn.xm.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/account")
public class LoginController {
    private static Logger logger = Logger.getLogger(LoginController.class);
    // 跳转登录页面
    @RequestMapping(value = "/login", method = {RequestMethod.GET})
    public String loginIndex(HttpServletRequest request, Model model) {
        logger.info("mmmmmm");
        return "login";
    }
}
