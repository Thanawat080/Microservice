package com.service.store.core.event;

import lombok.Data;

@Data
public class StoreCreateEvent {

    private  String storeId;
    private  String storename;
    private  String description;
    private  String rent_type;
    private  Integer reportnumber;
    private  String sellerId;
    private  String picture;
}

