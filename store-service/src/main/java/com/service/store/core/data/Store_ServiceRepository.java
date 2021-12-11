package com.service.store.core.data;

import com.service.store.core.StoreEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface Store_ServiceRepository extends MongoRepository<StoreEntity, Long> {
    StoreEntity findByStoreId(String id);

    StoreEntity findBySellerId(String id);

}
