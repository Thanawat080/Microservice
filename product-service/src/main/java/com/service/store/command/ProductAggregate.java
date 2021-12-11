package com.service.store.command;

import com.service.store.core.event.DeleteEvent;
import com.service.store.core.event.ProductCreateEvent;


import com.service.store.core.event.UpdateProductEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.util.List;

@Aggregate
public class ProductAggregate {

    @AggregateIdentifier
    private String id;
    private List<String> pic;
    private String product_name;
    private Integer price;
    private Integer quantity;
    private String description;
    private String storeId;
    private String category;

    public ProductAggregate(){

    }




    @CommandHandler
    public ProductAggregate(CreateProductCommand createProductCommand){
        System.out.println("Created");
        ProductCreateEvent productCreateEvent = new ProductCreateEvent();
        BeanUtils.copyProperties(createProductCommand, productCreateEvent);
        AggregateLifecycle.apply(productCreateEvent);
    }



    @EventSourcingHandler
    public void on(ProductCreateEvent productCreateEvent){
        this.id = productCreateEvent.getId();
        this.pic = productCreateEvent.getPic();
        this.product_name = productCreateEvent.getProduct_name();
        this.price = productCreateEvent.getPrice();
        this.quantity = productCreateEvent.getQuantity();
        this.description = productCreateEvent.getDescription();
        this.storeId = productCreateEvent.getStoreId();
        this.category = productCreateEvent.getCategory();
    }




    @CommandHandler
    public void handle(UpdateProductCommand updateProductCommand){
        UpdateProductEvent updateProductEvent = new UpdateProductEvent();
        BeanUtils.copyProperties(updateProductCommand, updateProductEvent);
        AggregateLifecycle.apply(updateProductEvent);
    }

    @EventSourcingHandler
    public void on(UpdateProductEvent updateProductEvent){
        this.id = updateProductEvent.getId();
        this.product_name = updateProductEvent.getProduct_name();
        this.price = updateProductEvent.getPrice();
        this.quantity = updateProductEvent.getQuantity();
        this.description = updateProductEvent.getDescription();
        this.category = updateProductEvent.getCategory();


    }


    @CommandHandler
    public void handle(DeleteCommand deleteCommand){
        DeleteEvent deleteEvent = new DeleteEvent();
        BeanUtils.copyProperties(deleteCommand, deleteEvent);
        AggregateLifecycle.apply(deleteEvent);
    }


    @EventSourcingHandler
    public void on(DeleteEvent deleteEvent){
        this.id = deleteEvent.getId();

    }

}
