package com.ljfzd6.goddemo.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public interface CommentService {
     List<Map<String,Object>> getAllComment();
     List<Map<String,Object>> getAllReply(Integer id);


}
