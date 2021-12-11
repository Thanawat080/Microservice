package com.example.demo.core.event;

import lombok.Data;

@Data
public class UserUpdateIdCardEvent {
    private String id;
    private String idCard;
    private String pictureIdCard;
}
