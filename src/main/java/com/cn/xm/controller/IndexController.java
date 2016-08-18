package com.cn.xm.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author qiuwenming@xiaomi.com
 * @since 2016年8月18日 下午8:27:34
 */
@Controller
@RequestMapping("/home")
public class IndexController {
    private static Logger logger = LoggerFactory.getLogger(IndexController.class);

    @RequestMapping("")
    public String loginIndex(HttpServletRequest request, Model model) {
        logger.info("mmmmmm");
        model.addAttribute("hasSign", request.getParameter("hasSign"));
        return "index";
    }

}
