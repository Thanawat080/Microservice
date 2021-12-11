package com.service.store.command;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Builder
@Data
public class UpdateUserCommand {
    public UpdateUserCommand(String id, String username) {
        this.id = id;
        this.username = username;
    }

    @TargetAggregateIdentifier
    private final String id;
    private final String username;
}
