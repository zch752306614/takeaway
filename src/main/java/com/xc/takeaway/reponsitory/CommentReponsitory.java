package com.xc.takeaway.reponsitory;

import com.xc.takeaway.utils.shopComment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
@Mapper
public interface CommentReponsitory {

    public Integer insertComment(shopComment shopComment);

    public Map<String, Object> getComment(String id);

}
