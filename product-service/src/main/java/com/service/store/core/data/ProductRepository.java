package com.service.store.core.data;

import com.service.store.core.ProductEntity;
import com.service.store.query.rest.ProductRestModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends MongoRepository<ProductEntity, String> {
    List<ProductRestModel> findByStoreId(String id);


}
