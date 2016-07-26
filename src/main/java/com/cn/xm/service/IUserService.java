package com.cn.xm.service;

import com.cn.xm.pojo.User;

public interface IUserService {
    public User getUserById(int userId);
    public void deleteUserById(int userId);
    public int insertUser(User user);
}
