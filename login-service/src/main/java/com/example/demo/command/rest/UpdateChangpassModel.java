package com.example.demo.command.rest;

import lombok.Data;

import java.io.Serializable;


@Data
public class UpdateChangpassModel {
    private  String id;
    private  String newpass;
    private  String oldpass;
}
