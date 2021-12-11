package com.example.demo.core.event;

import lombok.Data;

@Data

public class UserChangepassEvent {
    private  String id;
    private  String newpass;
    private  String oldpass;
}
