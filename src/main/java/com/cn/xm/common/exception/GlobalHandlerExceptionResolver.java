package com.cn.xm.common.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author qiuwenming@xiaomi.com
 * @since 2016年8月28日 上午10:12:53
 */
public class GlobalHandlerExceptionResolver implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        if (ex == null) {
            return null;
        }
        if (ex instanceof NullPointerException) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("errorMsg", "业务抛出NULLPOINT");// 将错误信息传递给view
            return new ModelAndView("error", map);
        }
        return null;
    }

}
