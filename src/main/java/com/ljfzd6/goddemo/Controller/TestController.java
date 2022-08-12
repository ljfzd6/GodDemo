package com.ljfzd6.goddemo.Controller;

import com.ljfzd6.goddemo.entity.GodUser;
import com.ljfzd6.goddemo.service.UserService;
import com.ljfzd6.goddemo.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class TestController {
    @Autowired
    UserService userService;
    @RequestMapping("/login")
    public R login(@RequestParam("username") String username,
                   @RequestParam("password") String password)
    {
        GodUser userByUsername = userService.getUserByUsername(username);
        System.out.println("哈哈"+userByUsername);
        if (userByUsername!=null)
        {
            if (userByUsername.getPassword().equals(password))
            {
                System.out.println("密码");
                return new R(200,true);
            }
            else  {
                return new R(500,false);
            }
        }
        else
        {
            return new R(500,false);
        }

    }

}
