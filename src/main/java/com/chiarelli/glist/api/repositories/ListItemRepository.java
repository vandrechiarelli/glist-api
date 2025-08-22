package com.chiarelli.glist.api.repositories;

import com.chiarelli.glist.api.dtos.ListItemDTO;
import com.chiarelli.glist.api.models.ListItem;
import com.chiarelli.glist.api.models.ListItemId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListItemRepository extends JpaRepository<ListItem, ListItemId> {
    @Query(nativeQuery = true, name = "ListItem.getListItems")
    List<ListItemDTO> getListItems();

    @Query(nativeQuery = true, name = "ListItem.getListItemsByListId")
    List<ListItemDTO> getListItemsByListId(Long listId);

    @Query(nativeQuery = true, name = "ListItem.getListAvailableItems")
    List<ListItemDTO> getListAvailableItems(Long listId);
}