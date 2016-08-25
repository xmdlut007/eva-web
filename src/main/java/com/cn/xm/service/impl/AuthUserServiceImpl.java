package com.cn.xm.service.impl;

import com.cn.xm.common.model.AuthUser;
import com.cn.xm.common.utils.PasswordUtil;
import com.cn.xm.dao.AuthUserMapper;
import com.cn.xm.service.AuthUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qiuwenming@xiaomi.com
 * @since 2016年8月24日 下午10:21:11
 */
@Service
public class AuthUserServiceImpl implements AuthUserService {

    @Autowired
    private AuthUserMapper authUserMapper;

    @Override
    public AuthUser getUserByUsernameEmail(Map<String, Object> map) {
        return authUserMapper.selectByUsernameEmail(map);
    }
    @Override
    public int insertAuthUser(AuthUser authUser) {
        return authUserMapper.insertSelective(authUser);
    }
    @Override
    public boolean loginValidate(String username, String password) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("username", username);
        AuthUser authUser = authUserMapper.selectByUsernameEmail(map);
        if (authUser == null) {
            map.clear();
            map.put("email", username);
            authUser = authUserMapper.selectByUsernameEmail(map);
            if (authUser == null) {
                return false;
            }
        }
        return PasswordUtil.checkLoginPassword(password, authUser.getPassword());
    }
    @Override
    public int updateByEmailSelective(AuthUser authUser) {
        return authUserMapper.updateByEmailSelective(authUser);
    }

}
