package com.ljfzd6.goddemo.mapper;

import com.ljfzd6.goddemo.entity.GodUserImage;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserImageMapper {
    @Insert("INSERT INTO god_user_image VALUES (null,#{identitycard},null,#{userid})")
     boolean insertUserImage(GodUserImage godUserImage);
    @Update("update god_user_image set usericon=#{usericon}  where userid=#{userid}")
    boolean insertUserIcon(GodUserImage godUserImage);
    @Select("select god_user_image.usericon from god_user left join god_user_image on god_user.id = god_user_image.userid where god_user.username = #{username}")
    String getUserIconByUsername(String username);
    @Select("select usericon from god_user_image  where god_user_image.userid = #{id}")
    String getUserIconById(Integer id);

}
