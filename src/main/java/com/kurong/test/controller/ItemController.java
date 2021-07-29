package com.kurong.test.controller;

import com.alibaba.fastjson.JSON;
import com.kurong.test.bean.Item;
import com.kurong.test.bean.QueryInfo;
import com.kurong.test.dao.ItemDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private ItemDao itemdao;
    @RequestMapping("/allItem")
    public String getItemList(QueryInfo queryInfo) {
        // 获取查询信息
        int number = itemdao.getItemCounts("%" + queryInfo.getQuery() + "%", queryInfo.getType(), queryInfo.getOwner(), queryInfo.getEdit());
        int pageStart = (queryInfo.getPageNum() - 1) * queryInfo.getPageSize();

        List<Item> items = itemdao.getAllItem("%" + queryInfo.getQuery() + "%", queryInfo.getType(), pageStart, queryInfo.getPageSize(), queryInfo.getFilter(), queryInfo.getOwner(), queryInfo.getEdit());
        HashMap<String, Object> res = new HashMap<>();
        res.put("number", number);
        res.put("data", items);
        return JSON.toJSONString(res);
    }

    @RequestMapping("/showItemMessage")
    public String showItemMessage(@RequestBody Item item){
        Item it = itemdao.getItemMessage(item.getItem_name());
        return JSON.toJSONString(it);
    }

    @RequestMapping("/releaseItem")
    public String releaseItem(@RequestBody Item item) {
        int i = itemdao.releaseItem(item);
        return i > 0 ? "success" : "error";
    }

    @RequestMapping("/deleteGoods")
    public String deleteItem(String item_name){
        int i = itemdao.deleteItem(item_name);
        return i > 0 ? "success" : "error";
    }

    @RequestMapping("/getEdit")
    public String getEditItem(String item_name){
        Item it = itemdao.getItemMessage(item_name);
        return JSON.toJSONString(it);
    }

    @RequestMapping("/editGoods")
    public String editItem(@RequestBody Item item){
        int i = itemdao.editItem(item);
        return i > 0 ? "success" : "error";
    }
}
