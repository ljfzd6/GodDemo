package com.ljfzd6.goddemo.service;

import com.ljfzd6.goddemo.entity.GodUserImage;
import org.springframework.stereotype.Service;

@Service
public interface UserImageService  {
    public boolean addUserImage(GodUserImage godUserImage);
    public boolean addUserIcon(GodUserImage godUserImage);
    public String getUserIconByUsername(String username);
}
