package com.cn.xm.service;

import com.cn.xm.common.model.AuthUser;

/**
 * @author qiuwenming@xiaomi.com
 * @since 2016年8月23日 下午11:13:42
 */
public interface AuthUserService {
    public AuthUser getUserByUsername(String username);

    public int insertAuthUser(AuthUser authUser);

    public boolean loginValidate(String username, String password);

}
