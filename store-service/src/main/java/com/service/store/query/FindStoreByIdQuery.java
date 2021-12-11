package com.service.store.query;

import lombok.Data;

@Data
public class FindStoreByIdQuery {
    private String id;

    public FindStoreByIdQuery(String id) {
        this.id = id;
    }
}
