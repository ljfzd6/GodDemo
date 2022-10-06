package com.ljfzd6.goddemo.service;

import com.ljfzd6.goddemo.entity.GodUser;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
List<GodUser> getAllUser();
GodUser getUserByUsername(String Username);
boolean  updateUser(GodUser godUser);
boolean updatePassword(String password,String username);
boolean deleteuser(String username);
boolean adduser(GodUser godUser);
}
