package com.service.store.query;

import lombok.Data;

@Data
public class FindProductByIdQueryOne {
    private String id;
    public FindProductByIdQueryOne(String id) {
        this.id = id;
    }
}
