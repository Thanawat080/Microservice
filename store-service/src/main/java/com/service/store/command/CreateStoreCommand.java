package com.service.store.command;

import lombok.Data;
import lombok.Builder;
import org.axonframework.modelling.command.TargetAggregateIdentifier;


@Builder
@Data
public class CreateStoreCommand {

    @TargetAggregateIdentifier
    private final String storeId;
    private final String storename;
    private final String description;
    private final String rent_type;
    private final Integer reportnumber;
    private final String sellerId;
    private final String picture;


}

