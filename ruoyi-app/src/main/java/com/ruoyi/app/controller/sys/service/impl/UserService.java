package com.ruoyi.app.controller.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.app.controller.sys.entity.User;
import com.ruoyi.app.controller.sys.mapper.UserMapper;

@Service("userService")
public class UserService
{
    @Autowired
    UserMapper userMapper;

    public User findByUsername(String username)
    {
        User user = new User();
        user.setUsername(username);
        // return userMapper.selectOne(user);
        // 这里演示就直接返回了
        user.setPassword("123456");
        user.setId(1l);
        return user;
    }

    public User findUserById(long userId)
    {
        //return userMapper.selectByPrimaryKey(userId);
        User user = new User();
        user.setUsername("test");
        // return userMapper.selectOne(user);
        // 这里演示就直接返回了
        user.setPassword("123456");
        user.setId(userId);
        return user;
    }
}