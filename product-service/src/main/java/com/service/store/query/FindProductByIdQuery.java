package com.service.store.query;

import lombok.Data;

@Data
public class FindProductByIdQuery {
    private String id;

    public FindProductByIdQuery(String id) {
        this.id = id;
    }
}
