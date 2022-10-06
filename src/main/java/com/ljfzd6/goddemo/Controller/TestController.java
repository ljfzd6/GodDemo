package com.ljfzd6.goddemo.Controller;

import com.ljfzd6.goddemo.entity.mongodb.Comment;
import com.ljfzd6.goddemo.service.CommentMongodbService;
import com.ljfzd6.goddemo.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    CommentMongodbService commentMongodbService;
    @RequestMapping("/test")
    public R test() {
        Comment comment=new Comment();
        comment.setId("c6");
        comment.setFromuser("zwj");
        comment.setContent("张无忌");
        commentMongodbService.insertComment(comment);
        String s = commentMongodbService.selectCommentById(comment.getId()).toString();
        return new R(200,s);
    }
}

