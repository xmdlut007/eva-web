package com.cn.xm.controller;

import com.alibaba.fastjson.JSONObject;
import com.cn.xm.common.constants.ReturnCode;
import com.cn.xm.pojo.User;
import com.cn.xm.service.impl.UserServiceImpl;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/auth")
public class LoginController {
    private static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserServiceImpl userServiceImpl;
    // 跳转到登录页面
    @RequestMapping(value = "/signin", method = {RequestMethod.GET})
    public String loginIn(HttpServletRequest request, Model model) {
        logger.info("mmmmmm");
        return "signin";
    }
    // 跳转注册页面
    @RequestMapping(value = "/signup", method = {RequestMethod.GET})
    public String register(@ModelAttribute("form") User user,
            HttpServletRequest request,
            Model model) {
        logger.info("mmmmmm {}", user);
        return "signup";
    }

    // 注册账号
    @RequestMapping(value = "/signup", method = {RequestMethod.POST})
    @ResponseBody
    public ReturnCode signin(@RequestParam(value = "userName", required = true) String userName,
            @RequestParam(value = "password", required = true) String password,
            HttpServletRequest request, Model model) {
        // String userName = request.getParameter("userName");
        // String password = request.getParameter("password");
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        if (user != null && StringUtils.isNotBlank(user.getUserName())) {
            User dbUser = userServiceImpl.getUserByUsername(user.getUserName());
            logger.info("signin {}", user);
            if (dbUser != null) {
                model.addAttribute("hasSign", "已经注册");
                logger.info("mmmmmm {} {}", "已经注册", dbUser);
                return new ReturnCode(-1, "该账号已经注册使用");
                // return "redirect:/home";
            }
        }
        userServiceImpl.insertUser(user);
        // return "redirect:/home";
        return new ReturnCode(0, "账号注册成功");
    }
    // 登录账号
    @RequestMapping(value = "/signin", method = {RequestMethod.POST})
    @ResponseBody
    public ReturnCode login(@RequestParam(value = "userName", required = true) String userName,
            @RequestParam(value = "password", required = true) String password,
            @ModelAttribute("form") User user,
            HttpServletRequest request, Model model) {
        JSONObject jsonObject = new JSONObject();
        boolean login = userServiceImpl.loginValidate(userName, password);
        if (login) {
            logger.info("login sucess  {}", userName);
            return new ReturnCode(0, "sucess");
        } else {
            logger.info("login failuer  {}", userName);
            return new ReturnCode(-1, "failure");
        }
        
    }
}
