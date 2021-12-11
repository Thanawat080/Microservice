package com.service.store.query.rest;

import com.service.store.core.ProductEntity;
import com.service.store.query.FindProductByIdQuery;
import com.service.store.query.FindProductQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(value = "http://localhost:8080", allowCredentials = "true")
@RestController
@RequestMapping("/product")
public class ProductQueryController {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    QueryGateway queryGateway;


    @GetMapping
    public List<ProductRestModel> getProduct(){
        FindProductQuery findStoreQuery = new FindProductQuery();
        List<ProductRestModel> product = queryGateway.query(findStoreQuery, ResponseTypes.multipleInstancesOf(ProductRestModel.class)).join();
        return  product;
    }

    @GetMapping(value = "/{id}")
    public List<ProductRestModel> getProductByStoreId(@PathVariable String id){
        FindProductByIdQuery findStoreByIdQuery = new FindProductByIdQuery(id);
        List<ProductRestModel> productById = queryGateway.query(findStoreByIdQuery, ResponseTypes.multipleInstancesOf(ProductRestModel.class)).join();
        return productById;
    }


    @GetMapping(value = "/getproduct/{id}")
    public ProductEntity getOneProductById(@PathVariable String id){
        Object oneproductById = rabbitTemplate.convertSendAndReceive("MyDirectExchange", "productone", id);
        return (ProductEntity) oneproductById;
    }


}
