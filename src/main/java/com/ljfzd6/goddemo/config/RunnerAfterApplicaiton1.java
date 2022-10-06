package com.ljfzd6.goddemo.config;

import com.ljfzd6.goddemo.entity.mongodb.Comment;
import com.ljfzd6.goddemo.mapper.CommentMapper;
import com.ljfzd6.goddemo.service.CommentMongodbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
//项目启动后的运行顺序
@Order(1)
public class RunnerAfterApplicaiton1 implements CommandLineRunner {
    @Autowired
    CommentMapper commentMapper;
    @Autowired
    CommentMongodbService commentMongodbService;
    @Override
    public void run(String... args) throws Exception {
        List<Comment> comments=new ArrayList<>();
        List<Map<String, Object>> maps = commentMapper.selectAllComment();
        for (Map<String, Object> map:maps){
            System.out.println(map.toString());
            Comment comment=new Comment();
            comment.setFromuser(map.get("name").toString());
            comment.setContent(map.get("comment").toString());
            System.out.println(comment.toString());
            comments.add(comment);
        }
        commentMongodbService.insertManyComment(comments);
        System.out.println("加载数据到mongodb"+comments.toString());
    }
}
