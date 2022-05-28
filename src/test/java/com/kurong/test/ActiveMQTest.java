package com.kurong.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.jms.TextMessage;

/**
 * ActiveMq测试类，测试能否正常发送消息
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TestApplication.class)
public class ActiveMQTest {
    @Autowired
    private JmsTemplate jmsTemplate;

    @Test
    public void ptpSender() {
        jmsTemplate.send("all", session -> {
            TextMessage textMessage = session.createTextMessage("这是一条测试信息");
            return textMessage;
        });
    }
}
