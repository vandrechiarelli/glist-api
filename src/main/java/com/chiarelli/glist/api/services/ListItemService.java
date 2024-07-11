package com.chiarelli.glist.api.services;

import com.chiarelli.glist.api.models.ListItem;
import com.chiarelli.glist.api.models.ListItemId;
import com.chiarelli.glist.api.repositories.ListItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListItemService {

    private final ListItemRepository listItemRepository;

    @Autowired
    public ListItemService(ListItemRepository listItemRepository) {
        this.listItemRepository = listItemRepository;
    }

    public List<ListItem> getListItems() {
        return listItemRepository.findAll();
    }

    public List<ListItem> getListItemsByListId(Long listId) {
        ListItemId listItemId = new ListItemId();
        listItemId.setListId(listId);
        return listItemRepository.findAllItemsByListId(listItemId.getListId());
    }

    public ListItem getListItem(Long listId, Long storeAisleItemId) {
        ListItemId listItemId = new ListItemId();
        listItemId.setListId(listId);
        listItemId.setStoreAisleItemId(storeAisleItemId);
        return listItemRepository.findById(listItemId)
                .orElse(null);
    }

    public void newListItem(ListItem listItem) {
        listItemRepository.save(listItem);
    }

    public void saveListItem(Long listId, Long storeAisleItemId, ListItem listItem) {
        ListItemId listItemId = new ListItemId();
        listItemId.setListId(listId);
        listItemId.setStoreAisleItemId(storeAisleItemId);
        listItem.setId(listItemId);
        listItemRepository.save(listItem);
    }
}
