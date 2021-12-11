package com.service.store.core;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.io.Serializable;


@Document("store")
@Data
public class StoreEntity implements Serializable {


    private static final long serialVersionUID = -7287695002189459759L;
    @Id
    private  String storeId;
    private  String storename;
    private  String description;
    private  String rent_type;
    private  Integer reportnumber;
    private  String sellerId;
    private  String picture;
}
