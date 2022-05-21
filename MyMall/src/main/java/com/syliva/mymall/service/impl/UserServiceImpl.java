package com.syliva.mymall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.syliva.mymall.mapper.UserMapper;
import com.syliva.mymall.pojo.User;
import com.syliva.mymall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public User findById(String userId) {
        User user = userMapper.selectById(userId);

        return user;
    }

    @Override
    public List<User> selectByName(String name) {
        QueryWrapper<User> querywrapper = new QueryWrapper<>();

        querywrapper.like("name", name);

        List<User> users = userMapper.selectList(querywrapper);

        return users;
    }

    @Override
    public void addUser(User user) {
        userMapper.insert(user);
    }

    @Override
    public void removeUser(User user) {
        userMapper.deleteById(user);
    }

    @Override
    public void updateMoney(Double money, String userId) {
        User user = userMapper.selectById(userId);

        double realMoney = user.getMoney() - money;

        user.setMoney(realMoney);

        userMapper.updateById(user);
    }
}
