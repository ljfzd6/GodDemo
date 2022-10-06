package com.ljfzd6.goddemo.service.impl;

import com.ljfzd6.goddemo.entity.GodUser;
import com.ljfzd6.goddemo.mapper.CommentMapper;
import com.ljfzd6.goddemo.mapper.UserImageMapper;
import com.ljfzd6.goddemo.mapper.UserMapper;
import com.ljfzd6.goddemo.service.CommentService;
import com.ljfzd6.goddemo.service.UserImageService;
import com.ljfzd6.goddemo.service.UserService;
import com.ljfzd6.goddemo.utils.FileToBase64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentMapper commentMapper;
    @Autowired
    UserImageMapper userImageMapper;
    @Autowired
    UserMapper userMapper;
    @Override
    public List<Map<String, Object>> getAllComment() {
        List<Map<String, Object>> maps = commentMapper.selectAllComment();
        for (Map<String, Object> map:maps) {
            String usericon = map.get("headImg").toString();
            String imgBase = FileToBase64.getImgBase(usericon);
            map.put("headImg","data:image/jpeg;base64,"+imgBase);

        }
        return maps;
    }

    @Override
    public List<Map<String, Object>> getAllReply(Integer id) {
        List<Map<String, Object>> maps = commentMapper.selectAllReply(id);
        for (Map<String, Object> map:maps) {
            GodUser fromuser = userMapper.selectUserById((Integer) map.get("fromId"));
            System.out.println(fromuser);
            GodUser touser = userMapper.selectUserById((Integer) map.get("toId"));
            System.out.println(touser);
            String userIconById = userImageMapper.getUserIconById(fromuser.getId());
            System.out.println(userIconById);
            String imgBase = FileToBase64.getImgBase(userIconById);
            map.put("fromHeadImg","data:image/jpeg;base64,"+imgBase);
            map.put("from",fromuser.getUsername());
            map.put("to",touser.getUsername());
            map.put("toId",touser.getId());
        }

        return maps;
    }
}
