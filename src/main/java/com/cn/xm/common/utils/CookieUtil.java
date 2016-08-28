package com.cn.xm.common.utils;

import com.alibaba.fastjson.JSONObject;
import com.cn.xm.common.constants.EVAConstants;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author qiuwenming@xiaomi.com
 * @since 2016年8月28日 上午11:16:56
 */
public class CookieUtil {
    public static void addCookie(HttpServletResponse response, String name, String value, int maxAge) {
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(maxAge);
        // cookie.setPath("/");
        // cookie.setDomain(".eva.com");
        response.addCookie(cookie);
        response.addHeader("test", "test");
    }
    public static void addCookie(HttpServletResponse response, String name, String value, int maxAge, String domain) {
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(maxAge);
        cookie.setPath("/");
        cookie.setDomain(domain);
        response.addCookie(cookie);
    }
    public static Cookie getCookieByName(HttpServletRequest request, String name) {
        Cookie[] cookies = request.getCookies();
        if (null != cookies) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(name)) {
                    return cookie;
                }
            }
        }
        return null;
    }
    public static void addLoginInfoToCookie(HttpServletResponse httpServletResponse, String userid, String cookieName) {
        JSONObject log_json = new JSONObject();
        log_json.put("userid", userid);
        log_json.put("logintime", System.currentTimeMillis() / 1000);
        String cookie_value = log_json.toJSONString(); // TODO 设置一个加密算法
        cookie_value = DESUtil.encrypt(cookie_value, EVAConstants.eva_crypt_key);
        addCookie(httpServletResponse, cookieName, cookie_value, EVAConstants.cookie_expire_time);
    }
}
