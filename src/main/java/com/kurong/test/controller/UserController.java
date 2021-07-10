package com.kurong.test.controller;

import com.alibaba.fastjson.JSON;
import com.kurong.test.bean.QueryInfo;
import com.kurong.test.bean.User;
import com.kurong.test.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDao userdao;

    @RequestMapping("/allUser")
    public String getUserList(QueryInfo queryInfo) {
        int numbers = userdao.getUserCounts("%" + queryInfo.getQuery() + "%");
        int pageStart = (queryInfo.getPageNum() - 1) * queryInfo.getPageSize();

        List<User> users = userdao.getAllUser("%" + queryInfo.getQuery() + "%", pageStart, queryInfo.getPageSize());
        HashMap<String, Object> res = new HashMap<>();
        res.put("numbers", numbers);
        res.put("data", users);
        String res_string = JSON.toJSONString(res);
        return res_string;
    }

    @RequestMapping("/register")
    public String addUser(@RequestBody User user) {
        user.setRole("普通用户");
        user.setState(true);
        int i = userdao.addUser(user);
        System.out.println("注册");
        return i > 0 ? "success" : "error";
    }

    @RequestMapping("/CheckUser")
    public String checkUsername(@RequestBody User user){
        User us = userdao.checkUsername(user.getUsername());
        return us == null ? "error" : "ok";
    }
}
