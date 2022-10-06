package com.ljfzd6.goddemo.service.impl;

import com.ljfzd6.goddemo.entity.GodUserImage;
import com.ljfzd6.goddemo.mapper.UserImageMapper;
import com.ljfzd6.goddemo.service.UserImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserImageServiceImpl implements UserImageService {
    @Autowired
    UserImageMapper userImageMapper;
    @Override
    public boolean addUserImage(GodUserImage godUserImage) {
        return userImageMapper.insertUserImage(godUserImage);
    }

    @Override
    public boolean addUserIcon(GodUserImage godUserImage) {
        return userImageMapper.insertUserIcon(godUserImage);
    }

    @Override
    public String getUserIconByUsername(String username) {
        return  userImageMapper.getUserIconByUsername(username);
    }
}
