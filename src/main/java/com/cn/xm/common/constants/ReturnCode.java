package com.cn.xm.common.constants;
/**
 * @author qiuwenming@xiaomi.com
 * @since 2016年8月22日 下午10:12:44
 */
public class ReturnCode {
    public int code;
    public String message;
    public ReturnCode(int code, String message) {
        super();
        this.code = code;
        this.message = message;
    }
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

}
