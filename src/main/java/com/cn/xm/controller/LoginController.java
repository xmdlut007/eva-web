package com.cn.xm.controller;

import com.cn.xm.pojo.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/account")
public class LoginController {
    private static Logger logger = LoggerFactory.getLogger(LoginController.class);
    // 跳转登录页面
    @RequestMapping(value = "/login", method = {RequestMethod.GET})
    public String loginIndex(HttpServletRequest request, Model model) {
        logger.info("mmmmmm");
        return "login";
    }
    // 跳转登录页面
    @RequestMapping(value = "/register", method = {RequestMethod.POST})
    public String register(@RequestParam(value = "userName", required = true) String userName, @ModelAttribute("form") User user,
            HttpServletRequest request,
            Model model) {
        logger.info("mmmmmm {}", userName);
        logger.info("mmmmmm {}", user);
        return "login";
    }
}
