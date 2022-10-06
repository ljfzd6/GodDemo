package com.ljfzd6.goddemo.Controller;

import com.ljfzd6.goddemo.service.CommentService;
import com.ljfzd6.goddemo.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    CommentService commentService;
    //获取全部的评论
    @RequestMapping("/getallcomment")
    public R getAllComment () {
        List<Map<String, Object>> allComment = commentService.getAllComment();
        return  new R(200,allComment);
    }
    @RequestMapping("/getallreply")
    public R getAllReply (@RequestParam("id") Integer id) {
        System.out.println("读取回复");
        List<Map<String, Object>> allReply = commentService.getAllReply(id);
        return new R(200,allReply);
    }
}
