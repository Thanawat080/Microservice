package com.example.demo.command;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Builder
@Data
public class UpdateUserCommand {

    @TargetAggregateIdentifier
    private final String id;
    private final String f_name;
    private final String l_name;
    private final String phone_number;
    private final String email;
}
