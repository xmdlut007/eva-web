package com.cn.xm.service;

import com.cn.xm.pojo.User;

public interface IUserService {
    public User getUserById(int userId);
    public void deleteUserById(int userId);
    public int insertUser(User user);
    public User getUserByUsername(String username);
    public boolean loginValidate(String username, String password);

}
