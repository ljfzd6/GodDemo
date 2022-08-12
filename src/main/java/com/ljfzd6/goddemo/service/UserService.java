package com.ljfzd6.goddemo.service;

import com.ljfzd6.goddemo.entity.GodUser;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
public List<GodUser> getAllUser();
public GodUser getUserByUsername(String Username);
}
