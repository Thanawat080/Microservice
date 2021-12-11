package com.service.store.command.rest;

import lombok.Data;

@Data
public class CreateStoreRestModel {

    private String storename;
    private String description;
    private String rent_type;
    private Integer reportnumber;
    private String sellerId;
    private String picture;



}