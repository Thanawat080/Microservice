package com.example.demo.core.event;

import lombok.Data;

@Data
public class UserUpdateEvent {
    private String id;
    private String f_name;
    private String l_name;
    private String phone_number;
    private String email;
}
