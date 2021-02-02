package com.xc.takeaway.service;

import com.xc.takeaway.reponsitory.UserReponsitory;
import com.xc.takeaway.utils.Shop;
import com.xc.takeaway.utils.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class userService {

    @Autowired
    UserReponsitory userReponsitory;

    /**
     * 用户登录验证
     **/
    public Integer userCheck(User user) {
        return userReponsitory.userCheck(user);
    }

    /**
     * 用户注册
     **/
    public Integer userRegister(User user) {
        return userReponsitory.userRegister(user);
    }

    /**
     * 管理员登录验证
     **/
    public List<User> adminCheck(User user) {
        return userReponsitory.adminCheck(user);
    }

    /**
     * 用户数量
     **/
    public Integer userCount() {
        return userReponsitory.userCount();
    }

    /**
     * 管理员数量
     **/
    public Integer adminCount() {
        return userReponsitory.adminCount();
    }

    /**
     * 获取用户列表
     **/
    public List<User> allUsers(User user) {
        return userReponsitory.allUsers(user);
    }

    /**
     * 获取店铺列表
     **/
    public List<Shop> allshops(User user) {
        return userReponsitory.allshops(user);
    }

    /**
     * 用户新增店铺
     **/
    public Integer shoperRegister(User user) {
        return userReponsitory.shoperRegister(user);
    }

    /**
     * 变更店铺
     **/
    public Integer updateSelfshop(User user) {
        return userReponsitory.updateSelfshop(user);
    }

    /**
     * 重置用户
     **/
    public Integer reset(User user) {
        return userReponsitory.reset(user);
    }

    /**
     * 查询用户名是否重复
     **/
    public boolean isRepeat(User user) {
        List<User> list = userReponsitory.getUser(user);
        if (list != null && list.size() > 0) {
            return true;
        } else {
            return false;
        }
    }
}
