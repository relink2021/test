package com.kurong.test.controller;

import com.alibaba.fastjson.JSON;
import com.kurong.test.bean.*;
import com.kurong.test.dao.ItemDao;
import com.kurong.test.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class ShopCarController {

    @Autowired
    private ItemDao scdao;

    //获取某用户购物车内的商品,这里定义了一个实体叫ChekInfo，实体里的item_name实际上是localstorage('username')
    @RequestMapping("/allShopCar")
    public String getShopCarList(@RequestBody ChekInfo chekInfo) {
        int numbers = scdao.getShopCarCounts(chekInfo.getItem_name());
        List<ShopCar> shopcars = scdao.getAllShopCar(chekInfo.getItem_name());
        HashMap<String, Object> res = new HashMap<>();
        res.put("numbers", numbers);
        res.put("data", shopcars);
        String res_string = JSON.toJSONString(res);
        return res_string;
    }

    //删除操作
    @RequestMapping("/deleteShopCar")
    public String deleteShopCar(@RequestBody ShopCar shopCar) {
        int i = scdao.deleteShopCar(shopCar);
        return i > 0 ? "success" : "error";
    }


    //加入购物车（前端实现在shopmall和goodpage页
    @RequestMapping("/addCart")
    public String addCart(@RequestBody ShopCar shopCar) {
        //先判断购物车中是否存在该商品
        ShopCar sc = scdao.checkItem(shopCar);
        if (sc==null)
        {
            //如不存在，加入购物车
            int i = scdao.addCart(shopCar);
            return i > 0 ? "success" : "error";
        }
        else
        {
            //如存在，修改商品数量
            int i = scdao.editShopCar(shopCar);
            return i > 0 ? "success" : "error";
        }
    }
}
