package com.ljfzd6.goddemo.service.impl;

import com.ljfzd6.goddemo.entity.GodUser;
import com.ljfzd6.goddemo.mapper.UserMapper;
import com.ljfzd6.goddemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public List<GodUser> getAllUser() {
       return userMapper.selectAllUser();
    }

    @Override
    public GodUser getUserByUsername(String username) {
        return userMapper.selectUserByUsername(username);
    }
}
