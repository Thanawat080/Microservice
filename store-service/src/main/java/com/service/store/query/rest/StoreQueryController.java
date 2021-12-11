package com.service.store.query.rest;

import com.service.store.core.StoreEntity;
import com.service.store.query.FindSellerId;
import com.service.store.query.FindStoreByIdQuery;
import com.service.store.query.FindStoreQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(value = "http://localhost:8080", allowCredentials = "true")

@RestController
@RequestMapping("/store")
public class StoreQueryController {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    QueryGateway queryGateway;
    @GetMapping
    public  List<StoreRestModel> getStore(){
        FindStoreQuery findStoreQuery = new FindStoreQuery();
        List<StoreRestModel> store = queryGateway.query(findStoreQuery, ResponseTypes.multipleInstancesOf(StoreRestModel.class)).join();
        return  store;
    }

    @GetMapping(value = "/{id}")
    public StoreEntity getStoreById(@PathVariable String id){

        FindStoreByIdQuery findStoreByIdQuery = new FindStoreByIdQuery(id);
        StoreEntity storeEntity = queryGateway.query(findStoreByIdQuery, ResponseTypes.instanceOf(StoreEntity.class)).join();
        return storeEntity;
    }

    @GetMapping(value = "/check/{seller_id}")
    public StoreEntity getStoreByIdCheck(@PathVariable String seller_id){
        Object storecheck = rabbitTemplate.convertSendAndReceive("MyDirectExchange", "storecheck", seller_id);
        return (StoreEntity) storecheck;
    }

}
