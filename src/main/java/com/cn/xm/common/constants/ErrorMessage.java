package com.cn.xm.common.constants;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author qiuwenming@xiaomi.com
 * @since 2016年8月28日 上午10:57:07
 */
public class ErrorMessage {
    private int code;
    private String message;

    public ErrorMessage() {

    }
    public ErrorMessage(int code, String message) {
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
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
