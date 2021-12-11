package com.service.store.core.event;

import lombok.Data;

import java.util.List;

@Data
public class ProductCreateEvent {

    private  String id;
    private  List<String> pic;
    private  String product_name;
    private  Integer price;
    private  Integer quantity;
    private  String description;
    private  String storeId;
    private String category;
}

