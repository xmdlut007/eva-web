package com.cn.xm.controller;

import com.alibaba.fastjson.JSONObject;
import com.cn.xm.common.constants.EVAConstants;
import com.cn.xm.common.utils.CookieUtil;
import com.cn.xm.common.utils.DESUtil;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ConfigurableObjectInputStream;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class LoginInterceptor extends HandlerInterceptorAdapter {
    private static Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
    // 绕过 maven 强制依赖检查
    private ConfigurableObjectInputStream configurableObjectInputStream = null;

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // TODO Auto-generated method stub
        super.afterCompletion(request, response, handler, ex);
    }

    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // TODO Auto-generated method stub
        super.afterConcurrentHandlingStarted(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
            throws Exception {
        // TODO Auto-generated method stub
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 获取当前登录人信息
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        LoginRequired loginRequired = handlerMethod.getMethodAnnotation(LoginRequired.class);
        if (null == loginRequired) {
            logger.info("enter xx");
            // 没有声明权限,放行
            return true;
        }
        logger.info("enter preHandle {}", CookieUtil.getCookieByName(request, EVAConstants.user_token).getValue());

        String cookieValue = DESUtil.decrypt(CookieUtil.getCookieByName(request, EVAConstants.user_token).getValue(),
                EVAConstants.eva_crypt_key);
        logger.info("value {}", cookieValue);
        if (StringUtils.isNotBlank(cookieValue)) {
            JSONObject jsonObject = JSONObject.parseObject(cookieValue);
            if (jsonObject == null || !jsonObject.containsKey("userid")) {
                return false;
            }
            String username = jsonObject.getString("userid");
            logger.info("LoginInterceptor username {}", username);
            return true;
        } else {// 如果验证失败
            logger.info("fail");
            // 返回到登录界面
            response.sendRedirect("http://www.baidu.com");
            // response.sendRedirect("../account/login");
            // return "login";
            return true;
        }
    }

}
