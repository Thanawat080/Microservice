package com.example.demo.query;

import lombok.Data;

@Data
public class FindByUsernameAndPassword {
    private String usename;
    private String password;

    public FindByUsernameAndPassword(String usename, String password) {
        this.usename = usename;
        this.password = password;
    }
}
