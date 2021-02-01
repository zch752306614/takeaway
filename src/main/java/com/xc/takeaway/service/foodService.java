package com.xc.takeaway.service;

import com.xc.takeaway.reponsitory.FoodReponsitory;
import com.xc.takeaway.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class foodService {
    @Autowired
    FoodReponsitory foodReponsitory;

    /**
     * 商家列表
     **/
    public List<Shop> shopList() {
        return foodReponsitory.shopList();
    }

    /**
     * 菜列表
     **/
    public List<Food> foodList(Food food) {
        return foodReponsitory.foodList(food);
    }

    /**
     * 商家左侧列表
     **/
    public List<leftName> leftName(leftName leftName) {
        return foodReponsitory.leftName(leftName);
    }

    /**
     * 菜品评论
     **/
    public List<foodComment> foodComment(foodComment foodComment) {
        return foodReponsitory.foodComment(foodComment);
    }

    /**
     * 商家评论
     **/
    public List<shopComment> shopComment(shopComment shopComment) {
        return foodReponsitory.shopComment(shopComment);
    }

    /**
     * 商家信息
     **/
    public List<Shop> shopInfo(Shop shop) {
        return foodReponsitory.shopInfo(shop);
    }

    /**
     * 所有店铺的食品列表
     * */
    public List<Food> allFoods() {
        return foodReponsitory.allFoods();
    }

    /**
     * 更新食品
     **/
    public Integer updateFood(Food food) {
        return foodReponsitory.updateFood(food);
    }

    /**
     * 删除食品
     **/
    public Integer deleteFood(Food food) {
        return foodReponsitory.deleteFood(food);
    }

    /**
     * 新增食品
     **/
    public Integer insertFood(Food food) {
        return foodReponsitory.insertFood(food);
    }

    /**
     * 当前店铺的食品列表
     **/
    public List<Food> shopFoodlist(Food food) {
        return foodReponsitory.shopFoodlist(food);
    }

    /**
     * 店铺筛选
     **/
    public List<Shop> shopFilter(Shop shop) {
        return foodReponsitory.shopFilter(shop);
    }

    /**
     * 删除指定店铺的食品
     **/
    public Integer shopFooddelete(Food food) {
        return foodReponsitory.shopFooddelete(food);
    }

}
