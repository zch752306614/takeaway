package com.xc.takeaway.service;

import com.xc.takeaway.reponsitory.OrderReponsitory;
import com.xc.takeaway.utils.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class orderService {
    @Autowired
    OrderReponsitory orderReponsitory;

    /**
     * 新增订单
     **/
    public Integer insertOrder(Order order) {
        return orderReponsitory.insertOrder(order);
    }

    /**
     * 获取用户的订单列表
     **/
    public List<Order> selectObject(Order order) {
        return orderReponsitory.selectObject(order);
    }

    /**
     * 获取用户的订单列表
     **/
    public List<Map<String, Object>> getUserOrder(Order order) {
        return orderReponsitory.getUserOrder(order);
    }

    /**
     * 获取所有订单列表
     **/
    public List<Order> selectOrders() {
        return orderReponsitory.selectOrders();
    }

    /**
     * 更新订单信息
     **/
    public Integer updateOrder(Order order) {
        return orderReponsitory.updateOrder(order);
    }

    /**
     * 获取店铺的订单列表
     **/
    public List<Order> shoperOrders(Order order) {
        return orderReponsitory.shoperOrders(order);
    }

    /**
     * 获取店铺的订单列表
     **/
    public List<Map<String, Object>> getShopOrders(Order order) {
        return orderReponsitory.getShopOrders(order);
    }

    /**
     * 商家接单
     **/
    public Integer acceptOrder(Order order) {
        return orderReponsitory.acceptOrder(order);
    }

    /**
     * 商家拒绝接单
     **/
    public Integer refuseOrder(String order_id) {
        return orderReponsitory.refuseOrder(order_id);
    }

    /**
     * 用户取消订单
     **/
    public Integer canserOrder(String order_id) {
        return orderReponsitory.refuseOrder(order_id);
    }

}
