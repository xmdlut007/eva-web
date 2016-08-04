package com.cn.xm.controller;

import com.cn.xm.pojo.User;
import com.cn.xm.service.IUserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    @Resource
    private IUserService userService;

    @RequestMapping(value = "/{userId:[\\d]+}", method = {RequestMethod.GET, RequestMethod.POST})
    // @RequestMapping("/{userId}")
    public String toIndex(@PathVariable int userId, HttpServletRequest request, Model model) {
        // int userId = Integer.parseInt(request.getParameter("id"));
        User user = this.userService.getUserById(userId);
        model.addAttribute("user", user);

        logger.info("xxxxxxxx {}", user);
        // return "redirect:/appointments";
        return "showUser";
    }
    @RequestMapping(value = "/userid/{userId:[\\d]+}", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody
    User getUserJson(@PathVariable int userId, HttpServletRequest request, Model model) {
        User user = this.userService.getUserById(userId);
        return user;
    }

}
