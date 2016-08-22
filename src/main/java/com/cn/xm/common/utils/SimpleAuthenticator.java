package com.cn.xm.common.utils;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * @author qiuwenming@xiaomi.com
 * @since 2016年8月22日 下午10:47:23
 */
public class SimpleAuthenticator extends Authenticator {
    private String user;
    private String pwd;

    public SimpleAuthenticator(String user, String pwd) {
        this.user = user;
        this.pwd = pwd;
    }

    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(user, pwd);
    }

}
