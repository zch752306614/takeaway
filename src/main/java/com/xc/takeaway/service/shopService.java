package com.xc.takeaway.service;

import com.xc.takeaway.reponsitory.ShopReponsitory;
import com.xc.takeaway.utils.Shop;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class shopService {
    @Autowired
    ShopReponsitory shopReponsitory;

    /**
     * 店铺列表
     **/
    public List<Shop> shoplist(Shop shop) {
        return shopReponsitory.shoplist(shop);
    }

    /**
     * 更新店铺信息
     **/
    public Integer updateShop(Shop shop) {
        return shopReponsitory.updateShop(shop);
    }

    /**
     * 删除店铺
     **/
    public Integer deleteShop(Shop shop) {
        return shopReponsitory.deleteShop(shop);
    }

    /**
     * 新增店铺
     **/
    public Integer insertShop(Shop shop) {
        return shopReponsitory.insertShop(shop);
    }

    /**
     * 获取店铺信息
     **/
    public List<Shop> oneShop(Shop shop) {
        return shopReponsitory.oneShop(shop);
    }

    /**
     * 更新分数
     **/
    public Integer updateScore(Shop shop) {
        return shopReponsitory.updateScore(shop);
    }

    /**
     * 新增店铺
     **/
    public Integer insertSelfshop(Shop shop) {
        return shopReponsitory.insertSelfshop(shop);
    }

    /**
     * 更新店铺销量
     **/
    public Integer shopCount(Shop shop) {
        return shopReponsitory.shopCount(shop);
    }

    /**
     * 根据类型获取代店铺列表
     **/
    public List<Shop> shopTypelist(Shop shop) {
        return shopReponsitory.shopTypelist(shop);
    }

    /**
     * 根据平均分获取店铺列表
     **/
    public List<Shop> byAverage(Shop shop) {
        return shopReponsitory.byAverage(shop);
    }

    /**
     * 根据距离获取店铺列表
     **/
    public List<Shop> byDistance(Shop shop) {
        return shopReponsitory.byDistance(shop);
    }

}
