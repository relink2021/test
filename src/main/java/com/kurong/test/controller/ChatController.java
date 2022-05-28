package com.kurong.test.controller;

import com.alibaba.fastjson.JSON;
import com.kurong.test.bean.FileBody;
import com.kurong.test.bean.Message;
import com.kurong.test.dao.MessageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.TextMessage;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
public class ChatController {
    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private MessageDao messageDao;

    @RequestMapping("/sendMessage")
    public String sendMessage(@RequestBody Message message) {
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            message.setTimestamp(new Date());
            HashMap<String, Object> res = new HashMap<>();
            res.put("sender", message.getSender());
            res.put("receiver", message.getReceiver());
            res.put("message", message.getMessage());
            res.put("timestamp", df.format(message.getTimestamp()));
            String ret = JSON.toJSONString(res);
            jmsTemplate.send("all", session -> {
                TextMessage textMessage = session.createTextMessage(ret);
                return textMessage;
            });
            if(message.getSender().equals("sudo") && message.getReceiver().equals("sudo") && message.getMessage().equals("refresh")) {
                return "root";
            }
            int i = messageDao.addMessage(message);
            return i > 0 ? "success" : "error";
        } catch (Exception e) {
            return "error";
        }
    }

    @RequestMapping("/uploadFile")
    public String uploadFile(@RequestBody FileBody fileBody) {
        if(fileBody.getFileUrl() == null) {
            return null;
        }
        Message message = new Message();
        message.setSender(fileBody.getSender());
        message.setReceiver(fileBody.getReceiver());
        message.setType(1);
        message.setMessage(fileBody.getFileName());
        message.setFile_url(fileBody.getFileUrl());
        message.setTimestamp(new Date());
        int i = messageDao.addMessage(message);
        return i > 0 ? "success" : "error";
    }

    @RequestMapping("/loadMessage")
    public String loadMessage(String self, String chatter) {
        List<Message> messageList;
        if(!chatter.equals("公共聊天室")) {
            messageList = messageDao.loadMessage(self, chatter);
        } else {
            messageList = messageDao.loadMessagePlus(chatter);
        }
        HashMap<String, Object> res = new HashMap<>();
        res.put("msgList", messageList);
        return JSON.toJSONString(res);
    }
}
