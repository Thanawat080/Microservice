package com.service.store.command;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Builder
@Data
public class ReportCommand {
    @TargetAggregateIdentifier
    private final String storeId;
    private final int report;
}
