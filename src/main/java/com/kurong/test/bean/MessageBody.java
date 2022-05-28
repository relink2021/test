package com.kurong.test.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 信息体
 * sender: 发送方
 * receiver: 接收方
 * message: 消息内容
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MessageBody {
    private String sender;
    private String receiver;
    private String message;
}
