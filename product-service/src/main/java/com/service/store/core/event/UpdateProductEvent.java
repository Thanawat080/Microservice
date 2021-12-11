package com.service.store.core.event;

import lombok.Data;

@Data
public class UpdateProductEvent {
    private  String id;
    private  String product_name;
    private  Integer price;
    private  Integer quantity;
    private  String description;
    private String category;
}
