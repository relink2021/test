package com.kurong.test.dao;

import com.kurong.test.bean.Message;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageDao {

    int addMessage(Message message);
    List<Message> loadMessage(String self, String chatter);
    List<Message> loadMessagePlus(String chatter);
}
