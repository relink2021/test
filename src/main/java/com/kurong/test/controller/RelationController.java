package com.kurong.test.controller;

import com.alibaba.fastjson.JSON;
import com.kurong.test.bean.AccessInfo;
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

    @RequestMapping("/getAllAccess")
    public String getAllAccess(String username) {
        List<AccessInfo> accessInfoList = relationDao.getAllAccess(username);
        HashMap<String, Object> res = new HashMap<>();
        res.put("accessInfo", accessInfoList);
        return JSON.toJSONString(res);
    }

    @RequestMapping("/agreeAccess")
    public String agreeAccess(String self, String other) {
        int i = relationDao.agreeAccess(self, other);
        Relation relation = new Relation();
        relation.setFirst(other);
        relation.setSecond(self);
        int j = relationDao.addRelation(relation);
        return i * j != 0 ? "success" : "error";
    }

    @RequestMapping("/refuseAccess")
    public String refuseAccess(String self, String other) {
        int i = relationDao.refuseAccess(self, other);
        return i > 0 ? "success" : "error";
    }

    @RequestMapping("/addAccess")
    public String addAccess(String self, String other, String message) {
        AccessInfo accessInfo = new AccessInfo();
        accessInfo.setSender(self);
        accessInfo.setReceiver(other);
        accessInfo.setMessage(message);
        accessInfo.setAccess(0);
        int i = relationDao.addAccess(accessInfo);
        return i > 0 ? "success" : "error";
    }
}
