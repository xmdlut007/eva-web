package com.cn.xm.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author qiuwenming@xiaomi.com
 * @since 2016年8月18日 下午8:27:34
 */
@Controller
@RequestMapping("/home")
public class IndexController {
    private static Logger logger = LoggerFactory.getLogger(IndexController.class);

    @LoginRequired
    @RequestMapping("")
    public String loginIndex(HttpServletRequest request, HttpServletResponse httpServletResponse, Model model) {
        // CookieUtil.addLoginInfoToCookie(httpServletResponse, "qiuwenming",
        // EVAConstants.user_token);
        logger.info("xxxxxx");
        return "index";
    }

}
