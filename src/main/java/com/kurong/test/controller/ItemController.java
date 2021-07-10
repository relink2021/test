package com.kurong.test.controller;

import com.alibaba.fastjson.JSON;
import com.kurong.test.bean.Item;
import com.kurong.test.dao.ItemDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class ItemController {

    @Autowired
    ItemDao itemDao;
    @RequestMapping("/Items")
    public String getItems(){
        System.out.println("访问成功");
        HashMap<String, Object> data = new HashMap<>();
        List<Item> items = itemDao.getItems();
        data.put("items",items);
        String s = JSON.toJSONString(data);
        return s;
    }
}
