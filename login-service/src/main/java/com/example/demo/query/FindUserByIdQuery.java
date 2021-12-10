package com.example.demo.query;

import lombok.Data;

@Data
public class FindUserByIdQuery {
    private String id;

    public FindUserByIdQuery(String id) {
        this.id = id;
    }
}
