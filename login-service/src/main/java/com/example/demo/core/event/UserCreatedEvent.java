package com.example.demo.core.event;

import lombok.Data;

@Data
public class UserCreatedEvent {
    private String id;
    private String f_name;
    private String l_name;
    private String username;
    private String password;
    private String email;
    private String phone_number;
    private String usertype;

}
