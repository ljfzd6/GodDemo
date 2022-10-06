package com.ljfzd6.goddemo.service;

import com.ljfzd6.goddemo.entity.mongodb.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentMongodbService {
    void insertComment(Comment comment);
    void insertManyComment(List<Comment> comments);
    void updateComment(Comment comment);
    void deleteCommentByname(String name);
    List<Comment> selectCommentById(String id);
    List<Comment> selectComment();

}
