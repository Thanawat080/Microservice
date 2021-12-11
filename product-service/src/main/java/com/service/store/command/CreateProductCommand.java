package com.service.store.command;

import lombok.Data;
import lombok.Builder;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.List;


@Builder
@Data
public class CreateProductCommand {

    @TargetAggregateIdentifier
    private final String id;
    private final List<String> pic;
    private final String product_name;
    private final Integer price;
    private final Integer quantity;
    private final String description;
    private final String storeId;
    private final String category;

}

