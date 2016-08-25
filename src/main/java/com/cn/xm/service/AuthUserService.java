package com.cn.xm.service;

import com.cn.xm.common.model.AuthUser;

import java.util.Map;

/**
 * @author qiuwenming@xiaomi.com
 * @since 2016年8月23日 下午11:13:42
 */
public interface AuthUserService {
    public AuthUser getUserByUsernameEmail(Map<String, Object> map);

    public int insertAuthUser(AuthUser authUser);

    public boolean loginValidate(String username, String password);

    public int updateByEmailSelective(AuthUser authUser);

}
