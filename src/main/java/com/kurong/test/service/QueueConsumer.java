package com.kurong.test.service;

import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

@Component
public class QueueConsumer {

//    @JmsListener(destination = "all")
//    public void receiveMessage(Message message){
//        if(message instanceof TextMessage){
//            TextMessage textMessage = (TextMessage)message;
//            try {
//                System.out.println("接收消息："+textMessage.getText());
//            } catch (JMSException e) {
//                e.printStackTrace();
//            }
//        }
//    }
}
