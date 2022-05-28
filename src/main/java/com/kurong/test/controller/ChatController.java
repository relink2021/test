package com.kurong.test.controller;

import com.alibaba.fastjson.JSON;
import com.kurong.test.bean.MessageBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.TextMessage;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

@RestController
public class ChatController {
    @Autowired
    private JmsTemplate jmsTemplate;

    @RequestMapping("/sendMessage")
    public String sendMessage(@RequestBody MessageBody messageBody) {
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            HashMap<String, Object> res = new HashMap<>();
            res.put("sender", messageBody.getSender());
            res.put("receiver", messageBody.getReceiver());
            res.put("message", messageBody.getMessage());
            res.put("timestamp", df.format(new Date()));
            String ret = JSON.toJSONString(res);
            jmsTemplate.send("all", session -> {
                TextMessage textMessage = session.createTextMessage(ret);
                return textMessage;
            });
            return "success";
        } catch (Exception e) {
            return "error";
        }
    }
}
