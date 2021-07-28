package com.kurong.test.controller;

import com.alibaba.fastjson.JSON;
import com.kurong.test.bean.QueryInfo;
import com.kurong.test.bean.User;
import com.kurong.test.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class UserController {

    @Autowired
    private UserDao userdao;

    @RequestMapping("/allUser")
    public String getUserList(QueryInfo queryInfo) {
        // 获取查询信息
        int number = userdao.getUserCounts("%" + queryInfo.getQuery() + "%");
        int pageStart = (queryInfo.getPageNum() - 1) * queryInfo.getPageSize();

        List<User> users = userdao.getAllUser("%" + queryInfo.getQuery() + "%", pageStart, queryInfo.getPageSize());
        HashMap<String, Object> res = new HashMap<>();
        res.put("number", number);
        res.put("data", users);
        return JSON.toJSONString(res);
    }

    @RequestMapping("/register")
    public String addUser(@RequestBody User user) {
        user.setRole("普通用户");
        user.setAddress(null);
        user.setReal_name(null);
        user.setSex("男");
        user.setState(true);
        int i = userdao.addUser(user);
        return i > 0 ? "success" : "error";
    }

    @RequestMapping("/addUser")
    public String addUserByAdmin(@RequestBody User user) {
        user.setAddress(null);
        user.setReal_name(null);
        user.setSex("男");
        user.setState(true);
        int i = userdao.addUser(user);
        return i > 0 ? "success" : "error";
    }

    @RequestMapping("/updateMessage")
    public String updateMessage(@RequestBody User user){
        int i = userdao.updateMessage(user);
        return i > 0 ? "success" : "error";
    }

    @RequestMapping("/updateState")
    public String updateState(@RequestBody User user) {
        int i = userdao.updateState(user);
        return i > 0 ? "success" : "error";
    }

    @RequestMapping("/checkUser")
    public String checkUsername(@RequestBody User user){
        User us = userdao.checkUsername(user.getUsername());
        return us == null ? "ok" : "error";
    }

    @RequestMapping("/showMessage")
    public String showMessage(@RequestBody User user){
        User us = userdao.checkUsername(user.getUsername());
        return JSON.toJSONString(us);
    }

    @RequestMapping("/deleteUser")
    public String deleteUser(String username){
        int i = userdao.deleteUser(username);
        return i > 0 ? "success" : "error";
    }

    @RequestMapping("/getUpdate")
    public String getUpdateUser(String username){
        User us = userdao.checkUsername(username);
        return JSON.toJSONString(us);
    }

    @RequestMapping("/updateUser")
    public String updateUser(@RequestBody User user){
        int i = userdao.updateUser(user);
        return i > 0 ? "success" : "error";
    }

    @RequestMapping("/reset")
    public String resetPassWord(@RequestBody User user){
        int i = userdao.resetPassWord(user);
        return i > 0 ? "success" : "error";
    }

    @RequestMapping("/oneUser")
    public String getOneUser(@RequestBody User user) {
        // 获取查询信息
        User the_user = userdao.checkUsername(user.getUsername());
        List<User> users = new ArrayList<>();
        users.add(the_user);
        return JSON.toJSONString(users);
    }
}
