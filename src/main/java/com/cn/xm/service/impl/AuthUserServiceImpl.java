package com.cn.xm.service.impl;

import com.cn.xm.common.model.AuthUser;
import com.cn.xm.common.utils.PasswordUtil;
import com.cn.xm.dao.AuthUserMapper;
import com.cn.xm.service.AuthUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author qiuwenming@xiaomi.com
 * @since 2016年8月24日 下午10:21:11
 */
@Service
public class AuthUserServiceImpl implements AuthUserService {

    @Autowired
    private AuthUserMapper authUserMapper;
    @Override
    public AuthUser getUserByUsername(String username) {
        return authUserMapper.selectByUsername(username);
    }
    @Override
    public int insertAuthUser(AuthUser authUser) {
        return authUserMapper.insertSelective(authUser);
    }
    @Override
    public boolean loginValidate(String username, String password) {
        AuthUser authUser = authUserMapper.selectByUsername(username);
        return PasswordUtil.checkLoginPassword(password, authUser.getPassword());
    }

}
