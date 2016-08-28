package com.cn.xm.common.constants;

import java.util.HashMap;
import java.util.Map;

public class EVAConstants {

    /**
     * 加密解密key
     */
    public final static String eva_crypt_key = "tl6XevAn";

    /**
     * cookie过期时间：7天
     */
    public final static int cookie_expire_time = 7 * 24 * 60 * 60;

    /**
     * token的有效时间
     */
    public final static int token_expire_time = 30;

    /**
     * 用以记录市场用户账号登录信息的cookie名称
     */
    public final static String user_token = "3gaH4Dps";
    /**
     * 每页显示条目数量
     */
    public final static int page_size = 20;

    public final static byte designer = 1;

    public final static byte developer = 2;

    public static final Map<String, String> LANG_PATH_MAP = new HashMap<String, String>();
    public static final String DEFAULT_LANG_PATH = "zh_CN";
    static {
        LANG_PATH_MAP.put("zh_CN", "zh_CN");
        LANG_PATH_MAP.put("en_US", "en_US");
    }
}
