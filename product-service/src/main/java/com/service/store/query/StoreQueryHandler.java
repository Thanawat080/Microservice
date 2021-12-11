package com.service.store.query;

import com.service.store.core.ProductEntity;
import com.service.store.core.data.ProductRepository;
import com.service.store.query.rest.ProductRestModel;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StoreQueryHandler {
    private final ProductRepository productRepository;

    public StoreQueryHandler(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @QueryHandler
    List<ProductRestModel> findproduct(FindProductQuery query){
        List<ProductRestModel> productRestModels = new ArrayList<>();
        List<ProductEntity> product = productRepository.findAll();
        for(ProductEntity productEntity : product){
            ProductRestModel productRestModel =new ProductRestModel();
            BeanUtils.copyProperties(productEntity, productRestModel);
            productRestModels.add(productRestModel);
        }
        return productRestModels;
    }

    @QueryHandler
        List<ProductRestModel> findstorebyId(FindProductByIdQuery query){
        List<ProductRestModel> productRestModels = new ArrayList<>();
        List<ProductRestModel> product = productRepository.findByStoreId(query.getId());
        for(ProductRestModel productEntity : product){
            ProductRestModel productRestModel =new ProductRestModel();
            BeanUtils.copyProperties(productEntity, productRestModel);
            productRestModels.add(productRestModel);
        }
        return productRestModels;
    }


    @QueryHandler
    ProductEntity findproductonebyId(FindProductByIdQueryOne query){

        ProductEntity productEntity = productRepository.findById(query.getId()).get();
        return productEntity;
    }
}
