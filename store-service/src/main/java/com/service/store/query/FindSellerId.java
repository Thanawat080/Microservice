package com.service.store.query;
import lombok.Data;

@Data
public class FindSellerId {

    private String sellerId;

    public FindSellerId(String id) {
        this.sellerId = id;
    }
}
