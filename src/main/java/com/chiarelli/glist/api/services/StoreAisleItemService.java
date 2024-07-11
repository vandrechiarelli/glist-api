package com.chiarelli.glist.api.services;

import com.chiarelli.glist.api.dtos.StoreAisleItemListDTO;
import com.chiarelli.glist.api.dtos.StoreAisleUrgentItemListDTO;
import com.chiarelli.glist.api.models.StoreAisleItem;
import com.chiarelli.glist.api.repositories.StoreAisleItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreAisleItemService {

    private final StoreAisleItemRepository storeAisleItemRepository;

    @Autowired
    public StoreAisleItemService(StoreAisleItemRepository storeAisleItemRepository) {
        this.storeAisleItemRepository = storeAisleItemRepository;
    }

    public List<StoreAisleItem> getAllStoreAisleItems() {
        return storeAisleItemRepository.findAll();
    }

    public List<StoreAisleItemListDTO> getStoreAisleItemList() {
        return storeAisleItemRepository.getStoreAisleItemList(1L);
    }

    public List<StoreAisleUrgentItemListDTO> getStoreAisleUrgentItemList() {
        return storeAisleItemRepository.getStoreAisleUrgentItemList();
    }

    public void addStoreAisleItem(StoreAisleItem storeAisleItem) {
        storeAisleItemRepository.save(storeAisleItem);
    }
}
