package com.example.demo.command;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.io.Serializable;

@Builder
@Data

public class UpdateChangepassCommand implements Serializable {
    @TargetAggregateIdentifier
    private final String id;
    private final String newpass;
    private final String oldpass;
}
