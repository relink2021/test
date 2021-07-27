package com.kurong.test.controller;

import com.alibaba.fastjson.JSON;
import com.kurong.test.bean.Item;
import com.kurong.test.bean.Order;
import com.kurong.test.bean.QueryInfo;
import com.kurong.test.dao.ItemDao;
import com.kurong.test.dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderDao orderdao;

    @RequestMapping("/allOrder")
    public String getOrderList(QueryInfo queryInfo) {
        // 获取查询信息
        int number = orderdao.getOrderCounts("%" + queryInfo.getQuery() + "%");
        int pageStart = (queryInfo.getPageNum() - 1) * queryInfo.getPageSize();
        List<Order> orders = orderdao.getAllOrder("%" + queryInfo.getQuery() + "%", pageStart, queryInfo.getPageSize());
        System.out.println(orders);
        for(Order order1:orders)
        {
            order1.setTotal(order1.getPrice()*order1.getAmount());
        }
        HashMap<String, Object> res = new HashMap<>();
        res.put("number", number);
        res.put("data", orders);
        return JSON.toJSONString(res);
    }

    @RequestMapping("/showOrderMessage")
    public String showOrderMessage(@RequestBody Order order){
        Order cur_order = orderdao.getOrderMessage(order.getItem_name(),order.getSellername(),order.getBuyername());
        List<Order> orders = new ArrayList<>();
        orders.add(cur_order);
        return JSON.toJSONString(orders);
    }

    @RequestMapping("/showUserBoughtOrder")
    public String showUserBoughtOrder(@RequestBody Order order)
    {
        List<Order> bought_orders = orderdao.getUserBoughtOrder(order.getBuyername());
        HashMap<String, Object> res = new HashMap<>();
        res.put("data", bought_orders);
        return JSON.toJSONString(res);
    }

    @RequestMapping("/searchUserItemBoughtOrder")
    public String searchUserItemBoughtOrder(@RequestBody Order order)
    {
        List<Order> bought_item_orders = orderdao.getUserItemBoughtOrder(order.getBuyername(),"%"+order.getSellername()+"%");
        HashMap<String, Object> res = new HashMap<>();
        System.out.println(bought_item_orders);
        res.put("data", bought_item_orders);
        return JSON.toJSONString(res);
    }

    //以下是购物车界面点击“结算”按钮后需要用到的
    //选中商品加入订单,跟加入购物车不同的是没有查重判断……
    @RequestMapping("/addOrder")
    public String addOrder(@RequestBody List<Order> orders) {
        for(Order cur_order:orders)
        {
            orderdao.addOrder(cur_order);
        }
        return "success" ;
    }

    //删除加入订单的商品
    @RequestMapping("/deleteItem")
    public String deleteOrder(@RequestBody List<Order> orders){
        //循环
        for(Order cur_order:orders)
        {
            orderdao.deleteShopCar(cur_order);//从购物车中删除
            int item_sub_car = orderdao.checkAmount(cur_order);//item_sub_car是item表中该商品的数量与cur_order商品的数量之差

            if (item_sub_car==0)
            {
                orderdao.deleteItem(cur_order);//从item中删除该商品
            }
            else if (item_sub_car>0)
            {
                orderdao.updateItemAmount(cur_order);//从item中减掉交易的商品数量
            }
            else  return "error";//只要有一个商品的库存不足，就退出循环，返回error
        }
        return "success" ;
    }
}
