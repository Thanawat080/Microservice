package com.service.store.query;

import com.service.store.core.ProductEntity;
import com.service.store.query.rest.ProductRestModel;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class RabbitQuery {
    @Autowired
    QueryGateway queryGateway;


    @RabbitListener(queues = "ProductOne")
    public ProductEntity getOneProductById(String id){
        FindProductByIdQueryOne findProductByIdQueryOne = new FindProductByIdQueryOne(id);
        ProductEntity productEntity = queryGateway.query(findProductByIdQueryOne, ResponseTypes.instanceOf(ProductEntity.class)).join();
        return productEntity;

    }

}
