package com.service.store.command;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Builder
@Data
public class DeleteCommand {

    @TargetAggregateIdentifier
    private final String id;
}
