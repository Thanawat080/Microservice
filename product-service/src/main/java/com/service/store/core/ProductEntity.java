package com.service.store.core;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.io.Serializable;
import java.util.List;


@Document("product")
@Data
public class ProductEntity implements Serializable {

    private static final long serialVersionUID = -5026347059588716288L;
    @Id
    private  String id;
    private List<String> pic;
    private  String product_name;
    private  Integer price;
    private  Integer quantity;
    private  String description;
    private  String storeId;
    private String category;
}
