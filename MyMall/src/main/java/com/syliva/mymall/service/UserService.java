package com.syliva.mymall.service;

import com.syliva.mymall.pojo.User;

import java.util.List;

public interface UserService {

    //根据id查找用户
    public User findById(String userId);

    //搜索用户
    List<User> selectByName(String name);

    //添加用户
    void addUser(User user);

    //删除用户
    void removeUser(User user);

    //减少金额
    void updateMoney(Double money, String userId);

}
