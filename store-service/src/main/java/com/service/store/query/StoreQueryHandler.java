package com.service.store.query;

import com.service.store.core.StoreEntity;
import com.service.store.core.data.Store_ServiceRepository;
import com.service.store.query.rest.StoreRestModel;
import org.apache.catalina.Store;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StoreQueryHandler {
    private final Store_ServiceRepository store_serviceRepository;

    public StoreQueryHandler(Store_ServiceRepository store_serviceRepository) {
        this.store_serviceRepository = store_serviceRepository;
    }

    @QueryHandler
    List<StoreRestModel> findstore(FindStoreQuery query){
        List<StoreRestModel> storeRestModels = new ArrayList<>();
        List<StoreEntity> store = store_serviceRepository.findAll();
        for(StoreEntity storeEntity: store){
            StoreRestModel storeRestModel =new StoreRestModel();
            BeanUtils.copyProperties(storeEntity, storeRestModel);
            storeRestModels.add(storeRestModel);
        }
        return storeRestModels;
    }

    @QueryHandler
    StoreEntity findstorebyId(FindStoreByIdQuery query){

        StoreEntity storeEntity = store_serviceRepository.findByStoreId(query.getId());
        return storeEntity;
    }

    @QueryHandler
    StoreEntity findseller_id(FindSellerId query){
        StoreEntity sellerId = store_serviceRepository.findBySellerId(query.getSellerId());
        return sellerId;
    }
}
