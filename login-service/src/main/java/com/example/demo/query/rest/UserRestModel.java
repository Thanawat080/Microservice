package com.example.demo.query.rest;

import lombok.Data;

@Data
public class UserRestModel {
    private String id;
    private String f_name;
    private String l_name;
    private String username;
    private String password;
    private String email;
    private String phone_number;
    private String usertype;
}
