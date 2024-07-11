package com.chiarelli.glist.api.controllers;

import com.chiarelli.glist.api.models.Store;
import com.chiarelli.glist.api.services.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="v1/store")
public class StoreController {

    private final StoreService storeService;

    @Autowired
    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping
    public List<Store> getStores() {
        return storeService.getStores();
    }

    @PostMapping
    public void addStore(@RequestBody Store store) {
        storeService.addStore(store);
    }
}
