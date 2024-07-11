package com.chiarelli.glist.api.controllers;

import com.chiarelli.glist.api.models.StoreAisle;
import com.chiarelli.glist.api.services.StoreAisleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="v1/store_aisle")
public class StoreAisleController {

    private final StoreAisleService storeAisleService;

    @Autowired
    public StoreAisleController(StoreAisleService storeAisleService) {
        this.storeAisleService = storeAisleService;
    }

    @GetMapping
    public List<StoreAisle> getStoreAisles() {
        return storeAisleService.getStoreAisles();
    }

    @PostMapping
    public void addStoreAisle(@RequestBody StoreAisle storeAisle) {
        storeAisleService.addStoreAisle(storeAisle);
    }
}
