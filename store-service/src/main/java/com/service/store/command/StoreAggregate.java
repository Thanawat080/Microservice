package com.service.store.command;

import com.service.store.core.event.ReportEvent;
import com.service.store.core.event.StoreCreateEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
public class StoreAggregate {

    @AggregateIdentifier
    private  String storeId;
    private  String storename;
    private  String description;
    private  String rent_type;
    private  Integer reportnumber;
    private  String sellerId;
    private  String picture;

    public StoreAggregate(){

    }
    @CommandHandler
    public StoreAggregate(CreateStoreCommand createStoreCommand){
        StoreCreateEvent storeCreateEvent = new StoreCreateEvent();
        BeanUtils.copyProperties(createStoreCommand, storeCreateEvent);
        AggregateLifecycle.apply(storeCreateEvent);
    }

    @EventSourcingHandler
    public void on(StoreCreateEvent storeCreateEvent){
        this.storeId = storeCreateEvent.getStoreId();
        this.storename = storeCreateEvent.getStorename();
        this.rent_type = storeCreateEvent.getRent_type();
        this.reportnumber = storeCreateEvent.getReportnumber();
        this.sellerId = storeCreateEvent.getSellerId();
        this.picture = storeCreateEvent.getPicture();
    }


    @CommandHandler
    public void on(ReportCommand reportCommand){
        ReportEvent reportEvent = new ReportEvent();
        BeanUtils.copyProperties(reportCommand, reportEvent);
        AggregateLifecycle.apply(reportEvent);
    }

    @EventSourcingHandler
    public void on(ReportEvent reportEvent){
        this.storeId = reportEvent.getStoreId();
        this.reportnumber = reportEvent.getReport();
    }
}
