package com.example.demo.command;

import lombok.Data;
import lombok.Builder;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.math.BigDecimal;


@Builder
@Data
public class CreateUserCommand {

    public CreateUserCommand(String id,String f_name, String l_name, String username, String password, String email, String phone_number,String usertype){
        this.id = id;
        this.f_name = f_name;
        this.l_name = l_name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone_number = phone_number;
        this.usertype = usertype;

    }

    @TargetAggregateIdentifier
    private final String id;
    private final String f_name;
    private final String l_name;
    private final String username;
    private final String password;
    private final String email;
    private final String phone_number;
    private final String usertype;


}
