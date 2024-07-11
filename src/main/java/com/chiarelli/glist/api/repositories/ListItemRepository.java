package com.chiarelli.glist.api.repositories;

import com.chiarelli.glist.api.models.ListItem;
import com.chiarelli.glist.api.models.ListItemId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListItemRepository extends JpaRepository<ListItem, ListItemId> {
    @Query("SELECT li FROM ListItem li WHERE li.id.listId = :listItemId")
    List<ListItem> findAllItemsByListId(Long listItemId);
}
