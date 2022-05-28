package com.kurong.test.bean;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class FileBody {
    private String sender;
    private String receiver;
    private String fileName;
    private String fileUrl;
}
