package com.service.store.command;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.io.Serializable;

@Builder
@Data

public class UpdateProductCommand  {

    @TargetAggregateIdentifier
    private final String id;
    private final String product_name;
    private final Integer price;
    private final Integer quantity;
    private final String description;
    private final String category;

}
