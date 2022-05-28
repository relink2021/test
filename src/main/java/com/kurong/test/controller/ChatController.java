package com.kurong.test.controller;

import com.kurong.test.bean.MessageBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.TextMessage;

@RestController
public class ChatController {
    @Autowired
    private JmsTemplate jmsTemplate;

    @RequestMapping("/sendMessage")
    public String sendMessage(@RequestBody MessageBody messageBody) {
        try {
            jmsTemplate.send("all", session -> {
                TextMessage textMessage = session.createTextMessage(messageBody.getMessage());
                return textMessage;
            });
            return "success";
        } catch(Exception e) {
            return "error";
        }
    }
}
