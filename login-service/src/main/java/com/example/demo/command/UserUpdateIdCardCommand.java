package com.example.demo.command;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Builder
@Data

public class UserUpdateIdCardCommand {
    @TargetAggregateIdentifier

    private final String id;
    private final String idCard;
    private final String pictureIdCard;
}
