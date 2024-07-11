package com.chiarelli.glist.api.repositories;

import com.chiarelli.glist.api.dtos.StoreAisleItemListDTO;
import com.chiarelli.glist.api.dtos.StoreAisleUrgentItemListDTO;
import com.chiarelli.glist.api.models.StoreAisleItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreAisleItemRepository extends JpaRepository<StoreAisleItem, Long> {

    //TODO: pass storeId through the method below
    @Query(nativeQuery = true)
    List<StoreAisleItemListDTO> getStoreAisleItemList(Long storeId);

    @Query(nativeQuery = true)
    List<StoreAisleUrgentItemListDTO> getStoreAisleUrgentItemList();
}
