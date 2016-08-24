package com.cn.xm.controller;

import com.alibaba.fastjson.JSONObject;
import com.cn.xm.common.constants.ReturnCode;
import com.cn.xm.common.model.AuthIdentifier;
import com.cn.xm.common.model.AuthUser;
import com.cn.xm.common.model.User;
import com.cn.xm.common.utils.MailSenderInfo;
import com.cn.xm.common.utils.PasswordUtil;
import com.cn.xm.common.utils.RandomUtil;
import com.cn.xm.filters.GlobalConfigureServiceContextListener;
import com.cn.xm.service.impl.AuthIdentifierServiceImpl;
import com.cn.xm.service.impl.AuthUserServiceImpl;
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
    @Autowired
    private AuthIdentifierServiceImpl authIdentifierServiceImpl;
    @Autowired
    private AuthUserServiceImpl authUserServiceImpl;
    // 跳转到登录页面
    @RequestMapping(value = "/signin", method = {RequestMethod.GET})
    public String loginIn(HttpServletRequest request, Model model) {
        return "signin";
    }
    // 跳转注册页面
    @RequestMapping(value = "/signup", method = {RequestMethod.GET})
    public String register(@ModelAttribute("form") User user, HttpServletRequest request, Model model) {
        logger.info("mmmmmm {}", user);
        return "signup";
    }

    // 注册账号
    @RequestMapping(value = "/signup", method = {RequestMethod.POST})
    @ResponseBody
    public ReturnCode signin(@RequestParam(value = "username", required = true) String username,
            @RequestParam(value = "password", required = true) String password,
            @RequestParam(value = "email", required = true) String email, @RequestParam(value = "code", required = true) String code,
            HttpServletRequest request, Model model) {

        AuthUser authUser = new AuthUser();
        authUser.setUsername(username);
        authUser.setPassword(PasswordUtil.encodeLoginPassword(password));
        authUser.setEmail(email);
        if (authUser != null && StringUtils.isNotBlank(authUser.getUsername())) {
            AuthUser authUserExist = authUserServiceImpl.getUserByUsername(username);
            if (authUserExist != null && StringUtils.isNotBlank(authUserExist.getUsername())) {
                // model.addAttribute("hasSign", "已经注册");
                return new ReturnCode(-1, "该账号已被使用");
                // return "redirect:/home";
            }
        }
        AuthIdentifier authIdentifier = new AuthIdentifier();
        authIdentifier.setData(email);
        authIdentifier.setCode(code);

        AuthIdentifier authIdentifierExist = authIdentifierServiceImpl.selectSelectiveAuthIdentifier(authIdentifier);
        if (authIdentifierExist == null) {
            return new ReturnCode(-1, "输入正确的验证码");
        }
        if (authIdentifierExist.getExpired() < System.currentTimeMillis()) {
            return new ReturnCode(-1, "验证码已过期");
        }

        authUserServiceImpl.insertAuthUser(authUser);
        authIdentifierServiceImpl.delectSelectiveAuthIdentifier(authIdentifierExist);
        // return "redirect:/home";
        return new ReturnCode(0, "账号注册成功");
    }
    // 登录账号
    @RequestMapping(value = "/signin", method = {RequestMethod.POST})
    @ResponseBody
    public ReturnCode login(@RequestParam(value = "username", required = true) String username,
            @RequestParam(value = "password", required = true) String password, @ModelAttribute("form") User user,
            HttpServletRequest request, Model model) {
        JSONObject jsonObject = new JSONObject();
        boolean login = authUserServiceImpl.loginValidate(username, password);
        if (login) {
            logger.info("login sucess  {}", username);
            return new ReturnCode(0, "sucess");
        } else {
            logger.info("login failuer  {}", username);
            return new ReturnCode(-1, "failure");
        }

    }
    @RequestMapping(value = "/signup/identifier", method = {RequestMethod.POST})
    @ResponseBody
    public Object getSignUpIdentifier(@RequestParam(value = "email", required = true) String email) {
        if (!MailSenderInfo.isEmail(email)) {
            return new ReturnCode(-1, "邮箱地址格式不正确");
        }
        AuthIdentifier tmpAuthIdentifier = new AuthIdentifier();
        tmpAuthIdentifier.setData(email);
        if (authIdentifierServiceImpl.selectSelectiveAuthIdentifier(tmpAuthIdentifier) != null) {
            return new ReturnCode(-1, "邮箱地址已被使用");
        }
        String uuid = RandomUtil.generateUUID();
        String code = RandomUtil.generateRandomDigitalStr(6);
        JSONObject res = new JSONObject();
        res.put("identifier_id", uuid);
        res.put("identifier_code", code);
        res.put("email", email);
        AuthIdentifier authIdentifier = new AuthIdentifier();
        authIdentifier.setType("email");
        authIdentifier.setUuid(uuid);
        authIdentifier.setCode(code);
        authIdentifier.setData(email);
        authIdentifier.setExpired(System.currentTimeMillis() + GlobalConfigureServiceContextListener.getIdentifierExpireTime());
        authIdentifierServiceImpl.insertAuthIdentifier(authIdentifier);
        return res;
    }
}
