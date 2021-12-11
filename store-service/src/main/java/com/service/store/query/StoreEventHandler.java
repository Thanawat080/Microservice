package com.service.store.query;

import com.service.store.core.StoreEntity;

import com.service.store.core.data.Store_ServiceRepository;
import com.service.store.core.event.ReportEvent;
import com.service.store.core.event.StoreCreateEvent;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class StoreEventHandler {
    private final Store_ServiceRepository storeRepository;

    public StoreEventHandler(Store_ServiceRepository storeRepository){
        this.storeRepository = storeRepository;
    }
    @EventHandler
    public void on(StoreCreateEvent event){
        StoreEntity storeEntity = new StoreEntity();
        BeanUtils.copyProperties(event, storeEntity);
        storeRepository.save(storeEntity);
    }

    @EventHandler
    public void on(ReportEvent event){
        StoreEntity storeEntity = storeRepository.findByStoreId(event.getStoreId());
        storeEntity.setReportnumber(storeEntity.getReportnumber()+1);
        storeRepository.save(storeEntity);
    }





}
