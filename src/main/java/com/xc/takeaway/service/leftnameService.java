package com.xc.takeaway.service;

import com.xc.takeaway.reponsitory.LeftNameReponsitory;
import com.xc.takeaway.utils.leftName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class leftnameService {

    @Autowired
    LeftNameReponsitory leftNameReponsitory;

    /**
     * 获取店铺分类
     **/
    public List<leftName> leftNames(leftName leftName) {
        return leftNameReponsitory.leftNames(leftName);
    }

    /**
     * 新增店铺分类
     **/
    public Integer insertName(leftName leftName) {
        return leftNameReponsitory.insertName(leftName);
    }

}
