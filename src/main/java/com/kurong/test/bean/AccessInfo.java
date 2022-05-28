package com.kurong.test.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 好友验证表单
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AccessInfo {
    private int access_id;
    private String sender;
    private String receiver;
    private String message;
    private int access;
}
