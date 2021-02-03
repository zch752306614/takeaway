package com.xc.takeaway.service;

import com.xc.takeaway.reponsitory.CommentReponsitory;
import com.xc.takeaway.utils.shopComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class commentService {
    @Autowired
    CommentReponsitory commentReponsitory;

    /**
     * 新增评论
     * */
    public Integer insertComment(shopComment shopComment) {
        return commentReponsitory.insertComment(shopComment);
    }

    /**
     * 查看评论
     **/
    public Map<String,Object> getComment(String id) {
        return commentReponsitory.getComment(id);
    }

}
