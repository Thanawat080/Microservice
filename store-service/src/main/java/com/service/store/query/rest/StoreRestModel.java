package com.service.store.query.rest;

import lombok.Data;

@Data
public class StoreRestModel {
    private  String storeId;
    private  String storename;
    private  String description;
    private  String rent_type;
    private  Integer reportnumber;
    private  String sellerId;
    private  String picture;
}
