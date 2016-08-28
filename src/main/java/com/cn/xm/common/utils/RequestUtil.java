package com.cn.xm.common.utils;
import javax.servlet.http.HttpServletRequest;

/**
 * @author qiuwenming
 * @since 2016-08-16 下午3:30:57
 */

public class RequestUtil {

    public static Long getLongAttributeFromRequest(HttpServletRequest request, String parameterName) {
        Object object = request.getAttribute(parameterName);
        if (object instanceof Long) {
            return (Long) object;
        } else {
            return null;
        }
    }

    public static String getStringAttributeFromRequest(HttpServletRequest request, String parameterName) {
        Object object = request.getAttribute(parameterName);
        if (object instanceof String) {
            return (String) object;
        } else {
            return null;
        }
    }

    public static Byte getByteAttributeFromRequest(HttpServletRequest request, String parameterName) {
        Object object = request.getAttribute(parameterName);
        if (object instanceof Byte) {
            return (Byte) object;
        } else {
            return null;
        }
    }

}
