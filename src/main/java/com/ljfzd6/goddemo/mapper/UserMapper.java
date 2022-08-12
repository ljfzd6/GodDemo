package com.ljfzd6.goddemo.mapper;

import com.ljfzd6.goddemo.entity.GodUser;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    @Select("select * from god_user")
    public List<GodUser> selectAllUser();
    @Select("select * from god_user where username = #{username}")
    public GodUser selectUserByUsername(String Username);

}
