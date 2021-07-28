package com.kurong.test.controller;

import com.alibaba.fastjson.JSON;
import com.kurong.test.bean.User;
import com.kurong.test.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class LoginController {

    @Autowired
    UserDao userDao;

    @RequestMapping("/Login")
    public String login(@RequestBody User user) {
        String flag = "error";
        User us = userDao.getUserByMessage(user.getUsername(),user.getPassword(),user.getRole());
        HashMap<String,Object> res = new HashMap<>();
        if(us != null && us.getState() == true)
        {
            flag = "ok";
        }
        res.put("flag",flag);
        res.put("user",us);
        System.out.println("user:"+us);
        String res_json = JSON.toJSONString(res);
        return res_json;
    }

    @RequestMapping("/ValidPandE")
    public String validPandE(@RequestBody User user){
        String flag = "error";
        User upe = userDao.getPandE(user.getUsername(),user.getPhone(),user.getEmail());
        HashMap<String,Object> res = new HashMap<>();
        if(upe != null)
        {
            flag = "ok";
        }
        res.put("flag",flag);
        res.put("user",upe);
        System.out.println("user:"+upe);
        String res_json = JSON.toJSONString(res);
        return res_json;
    }
}
