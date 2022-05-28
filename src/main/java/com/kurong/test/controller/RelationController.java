package com.kurong.test.controller;

import com.alibaba.fastjson.JSON;
import com.kurong.test.bean.Relation;
import com.kurong.test.dao.RelationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class RelationController {
    @Autowired
    private RelationDao relationDao;

    @RequestMapping("/getRelation")
    public String getAllRelation(String username) {
        List<Relation> relationList = relationDao.getAllRelation(username);
        List<String> friends = new ArrayList<>();
        for(Relation relation : relationList) {
            if(!relation.getFirst().equals(username)) {
                friends.add(relation.getFirst());
            }
            if(!relation.getSecond().equals(username)) {
                friends.add(relation.getSecond());
            }
        }
        HashMap<String, Object> res = new HashMap<>();
        res.put("friends", friends);
        return JSON.toJSONString(res);
    }
}
