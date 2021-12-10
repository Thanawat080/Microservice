package com.example.demo.core;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;


import java.io.Serializable;


@Document("user")
@Data
public class UserEntity implements Serializable {


    private static final long serialVersionUID = 3106264412778629176L;
    private String id;
    private String f_name;
    private String l_name;
    private String username;
    private String password;
    private String email;
    private String phone_number;
    private String usertype;
}
