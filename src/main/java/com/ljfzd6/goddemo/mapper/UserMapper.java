package com.ljfzd6.goddemo.mapper;

import com.ljfzd6.goddemo.entity.GodUser;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {
    @Select("select * from god_user")
    List<GodUser> selectAllUser();
    @Select("select * from god_user where username = #{username}")
    GodUser selectUserByUsername(String Username);
    @Update("update god_user set username=#{username},email=#{email},age=#{age},name=#{name}, phone=#{phone},address=#{address}  where id = #{id}")
    boolean updateUserById(GodUser godUser);
    @Update("UPDATE  god_user set password = #{password} where username = #{username}")
    boolean updatePasswordByUsername(@Param("password") String password,@Param("username")String username);
    @Delete("delete from god_user where username = #{username}")
    boolean deleteUserByUsername(String username);
    @Insert("insert into god_user values(null,#{username},#{password},#{age},#{name},#{phone},#{address},#{email})")
    boolean insertuser(GodUser godUser);
    @Select("select * from god_user where id = #{id}")
    GodUser selectUserById(Integer id);
}
