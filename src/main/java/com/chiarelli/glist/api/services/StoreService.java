package com.chiarelli.glist.api.services;

import com.chiarelli.glist.api.models.Store;
import com.chiarelli.glist.api.repositories.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService {

    private final StoreRepository storeRepository;

    @Autowired
    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    public List<Store> getStores() {
        return storeRepository.findAll();
    }

    public void addStore(Store store) {
        if (store.getName().isEmpty()) {
            throw new IllegalStateException("The store name is required");
        }
        storeRepository.save(store);
    }
}
