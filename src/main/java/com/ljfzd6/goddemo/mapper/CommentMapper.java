package com.ljfzd6.goddemo.mapper;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface CommentMapper {
    @Select("select  user.id 'id', user.username 'name' ,  usericon.usericon 'headImg' , comment.comment 'comment' , date_format(comment.time,'%Y-%m-%d %H:%i:%s') 'time' from (god_comment comment left join god_user user on comment.userid=user.id) left join god_user_image usericon on user.id=usericon.userid")
    List<Map<String,Object>> selectAllComment();
    @Select("select u.username 'from' , c.id 'toId' , u.id 'fromId' , r.reply 'comment' , date_format(r.time,'%Y-%m-%d %H:%i:%s') 'time' from  (god_comment c left join god_reply r on r.totid=c.id) left join god_user u on r.fromuserid = u.id where c.id= #{id}")
    List<Map<String,Object>> selectAllReply(Integer id);
}
