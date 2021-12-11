package com.service.store.command.rest;

import lombok.Data;

@Data
public class UpdateProductModel {

    private  String id;
    private  String product_name;
    private  Integer price;
    private  Integer quantity;
    private  String description;
    private String category;
}
