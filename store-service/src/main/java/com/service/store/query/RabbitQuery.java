package com.service.store.query;


import com.service.store.core.StoreEntity;
import com.service.store.core.data.Store_ServiceRepository;
import com.service.store.query.rest.StoreRestModel;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;



import java.util.List;
@Service

public class RabbitQuery {
    @Autowired
    Store_ServiceRepository repository;
    @Autowired
    QueryGateway queryGateway;


    @RabbitListener(queues = "Storecheck")
    public StoreEntity getUserByIdCheck(String seller_id){
        FindSellerId findBySeller_id = new FindSellerId(seller_id);
        StoreEntity storeEntity = queryGateway.query(findBySeller_id, ResponseTypes.instanceOf(StoreEntity.class)).join();
        return storeEntity;
    }
}
