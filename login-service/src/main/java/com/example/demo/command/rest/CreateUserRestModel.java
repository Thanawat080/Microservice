package com.example.demo.command.rest;

import lombok.Data;

@Data
public class CreateUserRestModel {
    private String f_name;
    private String l_name;
    private String username;
    private String password;
    private String email;
    private String phone_number;
    private String usertype;
}
