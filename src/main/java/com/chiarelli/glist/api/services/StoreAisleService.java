package com.chiarelli.glist.api.services;

import com.chiarelli.glist.api.models.StoreAisle;
import com.chiarelli.glist.api.repositories.StoreAisleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreAisleService {

    private final StoreAisleRepository storeAisleRepository;

    @Autowired
    public StoreAisleService(StoreAisleRepository storeAisleRepository) {
        this.storeAisleRepository = storeAisleRepository;
    }

    public List<StoreAisle> getStoreAisles() {
        return storeAisleRepository.findAll();
    }

    public void addStoreAisle(StoreAisle storeAisle) {
        storeAisleRepository.save(storeAisle);
    }
}
