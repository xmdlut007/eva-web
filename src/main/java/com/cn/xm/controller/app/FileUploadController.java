package com.cn.xm.controller.app;

import com.cn.xm.common.utils.FileUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import java.io.File;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/app")
public class FileUploadController {
    private static Logger logger = LoggerFactory.getLogger(FileUploadController.class);

    @RequestMapping(value = "/info", method = {RequestMethod.GET})
    public String uploadIndex(HttpServletRequest request, Model model) {
        return "app/appIndex";
    }
    @RequestMapping(value = "/upload", method = {RequestMethod.POST})
    public String uploadBasicInfo(@RequestParam("phoneIcon") MultipartFile phoneIcon, HttpServletRequest request, Model model) {
        if (!phoneIcon.isEmpty()) {
            logger.info("file basic info {} {}", phoneIcon.getOriginalFilename(), phoneIcon.getSize());

        }
        int returnCode = FileUtils.uploadFile(phoneIcon);
        logger.info("file basic info returncode{}", returnCode);
        return "app/appIndex";
    }
    @RequestMapping(value = "/upload1", method = {RequestMethod.POST})
    public String upload1BasicInfo(@RequestParam("phoneIcon") CommonsMultipartFile phoneIcon, HttpServletRequest request, Model model) {
        if (!phoneIcon.isEmpty()) {
            logger.info("file basic info {} {}", phoneIcon.getOriginalFilename(), phoneIcon.getSize());

        }
        File newFile = FileUtils.createTempFile(phoneIcon.getOriginalFilename());
        try {
            phoneIcon.transferTo(newFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "app/appIndex";
    }
    @RequestMapping(value = "/upload2", method = {RequestMethod.POST})
    public String upload2BasicInfo(@RequestParam("phoneIcon") CommonsMultipartFile phoneIcon, HttpServletRequest request, Model model) {
        long startTime = System.currentTimeMillis();
        // 将当前上下文初始化给 CommonsMutipartResolver （多部分解析器）
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        // 检查form中是否有enctype="multipart/form-data"
        if (multipartResolver.isMultipart(request)) {
            // 将request变成多部分request
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            // 获取multiRequest 中所有的文件名
            Iterator iter = multiRequest.getFileNames();

            while (iter.hasNext()) {
                // 一次遍历所有文件
                MultipartFile file = multiRequest.getFile(iter.next().toString());
                if (file != null) {
                    File newFile = FileUtils.createTempFile(phoneIcon.getOriginalFilename());
                    // 上传
                    try {
                        file.transferTo(newFile);
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }

            }

        }
        long endTime = System.currentTimeMillis();
        System.out.println("方法三的运行时间：" + String.valueOf(endTime - startTime) + "ms");
        return "app/appIndex";
    }
}
