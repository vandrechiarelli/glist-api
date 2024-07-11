package com.chiarelli.glist.api.controllers;

import com.chiarelli.glist.api.dtos.StoreAisleItemListDTO;
import com.chiarelli.glist.api.dtos.StoreAisleUrgentItemListDTO;
import com.chiarelli.glist.api.models.StoreAisleItem;
import com.chiarelli.glist.api.services.StoreAisleItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StoreAisleItemController {

    private final StoreAisleItemService storeAisleItemService;

    @Autowired
    public StoreAisleItemController(StoreAisleItemService storeAisleItemService) {
        this.storeAisleItemService = storeAisleItemService;
    }

    @RequestMapping(
            value = "v1/store_aisle_item",
            method = {RequestMethod.GET})
    public List<StoreAisleItem> getStoreAisleItem() {
        return storeAisleItemService.getAllStoreAisleItems();
    }

    @RequestMapping(
            value = "v1/store_aisle_all_item",
            method = {RequestMethod.GET})
    public List<StoreAisleItemListDTO> getStoreAisleItemList() {
        return storeAisleItemService.getStoreAisleItemList();
    }

    @RequestMapping(
            value = "v1/store_aisle_all_urgent_item",
            method = {RequestMethod.GET})
    public List<StoreAisleUrgentItemListDTO> getStoreAisleUrgentItemList() {
        return storeAisleItemService.getStoreAisleUrgentItemList();
    }

    @RequestMapping(
            value = "v1/store_aisle_item",
            method = {RequestMethod.POST})
    public void addStoreAisleItem(@RequestBody StoreAisleItem storeAisleItem) {
        storeAisleItemService.addStoreAisleItem(storeAisleItem);
    }
}
