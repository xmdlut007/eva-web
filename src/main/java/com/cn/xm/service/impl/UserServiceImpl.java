package com.cn.xm.service.impl;

import com.cn.xm.dao.UserMapper;
import com.cn.xm.pojo.User;
import com.cn.xm.service.IUserService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements IUserService {
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
}
