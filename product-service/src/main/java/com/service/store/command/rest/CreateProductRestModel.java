package com.service.store.command.rest;

import lombok.Data;

import java.util.List;

@Data
public class CreateProductRestModel {

    private List<String> pic;
    private String product_name;
    private Integer price;
    private Integer quantity;
    private String description;
    private String storeId;
    private String category;

}