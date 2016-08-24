package com.cn.xm.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author qiuwenming@xiaomi.com
 * @since 2016年8月24日 下午4:09:37
 */
public class GlobalConfigureServiceContextListener implements ServletContextListener {
    private static Logger logger = LoggerFactory.getLogger(GlobalConfigureServiceContextListener.class);
    private final static String GLOBAL_CONFIG_PATH = "global_config.properties";

    private static String MAIL_TEMPLATE = "";
    private static long expireTime = 0l;
    public static void initGlobalConfig(ServletContextEvent sce) {
        Properties properties = System.getProperties();
        Resource res = new ClassPathResource(GLOBAL_CONFIG_PATH);

        try {
            properties.load(res.getInputStream());
            System.setProperties(properties);
            MAIL_TEMPLATE = (String) System.getProperties().get("mail_template");
            expireTime = Long.parseLong((String) System.getProperties().get("AUTH_IDENTIFIER_TIMEOUT"));
            sce.getServletContext().setAttribute("expireTime", expireTime);
            logger.info("SendCloudMailUtil-INFO {}{}", MAIL_TEMPLATE, expireTime);
        } catch (IOException e) {
            logger.error("SendCloudMailUtil{}", e);
        }
    }
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // TODO Auto-generated method stub
        initGlobalConfig(sce);

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // TODO Auto-generated method stub

    }

}
