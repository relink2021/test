package com.kurong.test.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Message {
    private int message_id;
    private String sender;
    private String receiver;
    private String message;
    private Date timestamp;
}
