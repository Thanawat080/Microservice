package com.service.store.query;

import com.service.store.core.ProductEntity;

import com.service.store.core.data.ProductRepository;
import com.service.store.core.event.DeleteEvent;
import com.service.store.core.event.ProductCreateEvent;
import com.service.store.core.event.UpdateProductEvent;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ProductEventHandler {
    private final ProductRepository productRepository;

    public ProductEventHandler(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    @EventHandler
    public void on(ProductCreateEvent event){
        ProductEntity productEntity = new ProductEntity();
        BeanUtils.copyProperties(event, productEntity);
        productRepository.save(productEntity);
    }


    @EventHandler
    public void on(UpdateProductEvent event){
        ProductEntity productEntity = productRepository.findById(event.getId()).get();
        productEntity.setProduct_name(event.getProduct_name());
        productEntity.setDescription(event.getDescription());
        productEntity.setPrice(event.getPrice());
        productEntity.setCategory(event.getCategory());
        productRepository.save(productEntity);
    }

    @EventHandler
    public void on(DeleteEvent event){
        productRepository.deleteById(event.getId());
    }


}
