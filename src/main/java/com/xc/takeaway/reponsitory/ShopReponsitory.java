package com.xc.takeaway.reponsitory;

import com.xc.takeaway.utils.Shop;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface ShopReponsitory {
    public List<Shop> shoplist(Shop shop);

    //更新店铺信息
    public Integer updateShop(Shop shop);

    //删除店铺
    public Integer deleteShop(Shop shop);

    //删除店铺
    public Integer deleteUserShop(@Param("shopNum") String shopNum);

    //添加商铺
    public Integer insertShop(Shop shop);

    public List<Shop> oneShop(Shop shop);

    public Integer updateScore(Shop shop);

    public Integer insertSelfshop(Shop shop);

    public Integer shopCount(Shop shop);

    public List<Shop> shopTypelist(Shop shop);

    public List<Shop> byAverage(Shop shop);

    public List<Shop> byDistance(Shop shop);

    public List<Map<String,Object>> getShopCount(String shopNum);

}
