package com.cn.xm.service.impl;

import com.cn.xm.common.model.User;
import com.cn.xm.dao.UserMapper;
import com.cn.xm.service.IUserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements IUserService {
    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource
    private UserMapper userMapper;
    @Override
    public User getUserById(int userId) {
        // TODO Auto-generated method stub
        return this.userMapper.selectByPrimaryKey(userId);
    }
    @Override
    public void deleteUserById(int userId) {
        // TODO Auto-generated method stub
        this.userMapper.deleteByPrimaryKey(userId);
    }
    @Override
    public int insertUser(User user) {
        this.userMapper.insert(user);
        return 0;
    }
    @Override
    public User getUserByUsername(String username) {
        return this.userMapper.selectByUsername(username);
    }
    @Override
    public boolean loginValidate(String username, String password) {
        // TODO Auto-generated method stub
        logger.info("loginValidate {} {}", username, password);
        User user = this.userMapper.loginUser(username, password);
        if (user != null) {
            return true;
        }
        return false;
    }
}
