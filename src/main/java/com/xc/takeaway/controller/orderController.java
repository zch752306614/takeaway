package com.xc.takeaway.controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.xc.takeaway.WebAPIResult;
import com.xc.takeaway.service.orderService;
import com.xc.takeaway.service.shopService;
import com.xc.takeaway.utils.Food;
import com.xc.takeaway.utils.Order;
import com.xc.takeaway.utils.Shop;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONArray;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@Api(tags = "订单接口")
public class orderController {
    @Autowired
    orderService orderService;
    @Autowired
    shopService shopService;

    @ApiOperation("用户下单")
    @RequestMapping(value = "/insertOrder", method = RequestMethod.POST)
    public WebAPIResult insertOrder(@RequestBody JSONObject obj) {
        WebAPIResult webAPIResult = new WebAPIResult();

        String foodInfo = obj.getJSONArray("foodList").toJSONString();
        JSONArray foodList = JSONArray.fromObject(obj.getJSONArray("foodList"));

        //随机id
        String id;
        UUID uuid = UUID.randomUUID();
        id = uuid.toString();
        id = id.replace("-", "");
        int num = id.hashCode();
        num = num < 0 ? -num : num;
        id = String.valueOf(num);

        //设置日期格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        //店铺id
        String shopNum = foodList.getJSONObject(0).getString("shop_num");
        String extraInfo = obj.getString("extraInfo");
        String totalPrice = obj.getString("totalPrice");
        String locationInfo = obj.getString("locationInfo");
        String userName = obj.getString("user");
        String tel = obj.getString("tel");

        Shop myShop = new Shop();
        myShop.setShop_num(shopNum);
        List<Shop> shopList = shopService.oneShop(myShop);
        String shopImg = shopList.get(0).shop_img;

        Order order = new Order();
        order.setOrder_id(id);
        order.setShop_num(shopNum);
        order.setOrder_time(df.format(new Date()));
        order.setTotal_price(totalPrice);
        order.setPay_state("0");
        order.setFood_info(foodInfo);
        order.setExtra_info(extraInfo);
        order.setLocation(locationInfo);
        order.setUser_name(userName);
        order.setShop_img(shopImg);
        order.setTel(tel);
        System.out.println(order);

        int result = orderService.insertOrder(order);
        System.out.println(result);
        if (result == 1) {
            webAPIResult.setResult(0);
        } else {
            webAPIResult.setResult(1);
        }
        return webAPIResult;
    }

    @ApiOperation("获取用户所有订单")
    @RequestMapping(value = "/allOrders", method = RequestMethod.POST)
    public WebAPIResult selectOrder(@RequestBody Order order) {
        WebAPIResult webAPIResult = new WebAPIResult();

        List<Map<String, Object>> list = orderService.getUserOrder(order);
        //System.out.println(list);

        webAPIResult.setResult(0);
        webAPIResult.setData(list);
        return webAPIResult;
    }

    @ApiOperation("获取商家所有订单")
    @RequestMapping(value = "/shoperOrders", method = RequestMethod.POST)
    public WebAPIResult shoperOrders(@RequestBody Order order) {
        WebAPIResult webAPIResult = new WebAPIResult();
        //System.out.println(order);
        List<Map<String, Object>> list = orderService.getShopOrders(order);
        //System.out.println(list);

        webAPIResult.setResult(0);
        webAPIResult.setData(list);
        return webAPIResult;
    }

    @ApiOperation("获取所有订单")
    @RequestMapping(value = "/Orders", method = RequestMethod.POST)
    public WebAPIResult orders() {
        WebAPIResult webAPIResult = new WebAPIResult();

        List<Order> list = orderService.selectOrders();
//        System.out.println(list);

        webAPIResult.setResult(0);
        webAPIResult.setData(list);
        return webAPIResult;
    }

    @ApiOperation("用户收货")
    @RequestMapping(value = "/updateOrder", method = RequestMethod.POST)
    public WebAPIResult updateOrder(@RequestBody Order order) {
        WebAPIResult webAPIResult = new WebAPIResult();
        System.out.println(order);
        //获取订单信息
        Map<String, Object> rt = orderService.getOrderById(order.getOrder_id());
        String shopNum = rt.get("shop_num").toString();
        String totalPrice = rt.get("total_price").toString();
        String confirmState = rt.get("confirm_state").toString();
        String acceptState = rt.get("accept_state").toString();
        //商家未接单
        if (!acceptState.equals("1")) {
            webAPIResult.setResult(0);
            webAPIResult.setMessage("操作失败！");
        } else {
            order.setConfirm_state("1");
            int a = orderService.updateOrder(order);
            //获取店铺信息
            rt = orderService.getShopByNum(shopNum);
            System.out.println("rt=" + rt);
            String average = rt.get("average").toString();
            String sellCount = rt.get("sell_count").toString();
            if (a > 0) {
                //更新销量、人均消费
                a = orderService.updateShop(shopNum, Float.parseFloat(totalPrice));
                webAPIResult.setResult(0);
                webAPIResult.setData(a);
            }
        }
        return webAPIResult;
    }

    @ApiOperation("商家接单")
    @RequestMapping(value = "/acceptOrder", method = RequestMethod.POST)
    public WebAPIResult acceptOrder(@RequestBody Order order) {
        WebAPIResult webAPIResult = new WebAPIResult();
        System.out.println(order);
        order.setAccept_state("1");
        int a = orderService.acceptOrder(order);
        webAPIResult.setResult(0);
        webAPIResult.setData(a);
        return webAPIResult;
    }

    @ApiOperation("商家拒绝接单")
    @RequestMapping(value = "/refuseOrder", method = RequestMethod.POST)
    public WebAPIResult refuseOrder(@RequestBody JSONObject jsonObject) {
        String orderId = jsonObject.getString("order_id");
        WebAPIResult webAPIResult = new WebAPIResult();
        int a = orderService.refuseOrder(orderId);
        webAPIResult.setResult(0);
        webAPIResult.setData(a);
        return webAPIResult;
    }

    @ApiOperation("用户取消订单")
    @RequestMapping(value = "/canserOrder", method = RequestMethod.POST)
    public WebAPIResult canserOrder(@RequestBody JSONObject jsonObject) {
        String orderId = jsonObject.getString("order_id");
        WebAPIResult webAPIResult = new WebAPIResult();
        System.out.println("orderId=" + orderId);
        int a = orderService.canserOrder(orderId);
        webAPIResult.setResult(0);
        webAPIResult.setData(a);
        return webAPIResult;
    }

    @ApiOperation("用户删除历史订单")
    @RequestMapping(value = "/deleteOrder", method = RequestMethod.POST)
    public WebAPIResult deleteOrder(@RequestBody JSONObject jsonObject) {
        String orderId = jsonObject.getString("order_id");
        WebAPIResult webAPIResult = new WebAPIResult();
        int a = orderService.deleteOrder(orderId);
        webAPIResult.setResult(0);
        webAPIResult.setData(a);
        return webAPIResult;
    }

}
