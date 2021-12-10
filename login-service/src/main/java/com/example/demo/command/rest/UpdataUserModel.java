package com.example.demo.command.rest;

import lombok.Data;

@Data
public class UpdataUserModel {
    private String id;
    private String f_name;
    private String l_name;
    private String phone_number;
    private String email;
}
