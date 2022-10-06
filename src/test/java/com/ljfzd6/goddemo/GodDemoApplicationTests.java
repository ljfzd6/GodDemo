package com.ljfzd6.goddemo;

import com.ljfzd6.goddemo.Controller.CommentController;
import com.ljfzd6.goddemo.entity.mongodb.Comment;
import com.ljfzd6.goddemo.mapper.CommentMapper;
import com.ljfzd6.goddemo.mapper.UserImageMapper;
import com.ljfzd6.goddemo.service.CommentMongodbService;
import com.ljfzd6.goddemo.service.CommentService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ResourceUtils;

import javax.mail.MessagingException;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
class GodDemoApplicationTests {
//    @Autowired
//    RedisTemplate<String,Object> redisTemplate;
    @Autowired
    CommentMapper commentMapper;
    @Autowired
    UserImageMapper userImageMapper;
    @Autowired
    CommentService commentService;
    @Autowired

    @Test
    void contextLoads() throws MessagingException, FileNotFoundException {

//        String path = ResourceUtils.getURL("classpath:").getPath();
//        System.out.println(path);
//        redisTemplate.opsForValue().set("test","123",5, TimeUnit.SECONDS);
//        Object test = redisTemplate.opsForValue().get("test");
//        System.out.println(test);
//        List<Map<String, Object>> maps = commentMapper.selectAllReply(1);

//        String ddd = userImageMapper.getUserIconByUsername("ddd");
//        System.out.println(ddd);
//        List<Map<String, Object>> allReply = commentService.getAllReply(1);
//        for (Map<String,Object> map:allReply)
//        {
//            System.out.println(map.toString());
//        }
    }

}
