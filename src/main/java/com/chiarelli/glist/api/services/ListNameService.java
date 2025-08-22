package com.chiarelli.glist.api.services;

import com.chiarelli.glist.api.dtos.ListItemDTO;
import com.chiarelli.glist.api.models.Item;
import com.chiarelli.glist.api.models.ListItem;
import com.chiarelli.glist.api.models.ListItemId;
import com.chiarelli.glist.api.models.ListName;
import com.chiarelli.glist.api.repositories.ListItemRepository;
import com.chiarelli.glist.api.repositories.ListNameRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ListNameService {

    private static final Logger log = LoggerFactory.getLogger(ListNameService.class);
    private final ListNameRepository listNameRepository;
    private final ListItemRepository listItemRepository;

    @Autowired
    public ListNameService(ListNameRepository listNameRepository,
                           ListItemRepository listItemRepository) {
        this.listNameRepository = listNameRepository;
        this.listItemRepository = listItemRepository;
    }

    public List<ListName> getListNames() {
        return listNameRepository.findAll()
                .stream()
                .filter(item -> item.getIsDeleted() == false)
                .toList();
    }

    public ListName getListName(Long id) {
        return listNameRepository.findById(id)
                .orElse(null);
    }

    public void newListName(ListName listName) {
        listNameRepository.save(listName);
    }

    public Long saveListName(Long id, ListName listName) {
        if (listNameRepository.existsById(id)) {
            listName.setId(id);
            listNameRepository.save(listName);
        }
        return listName.getId();
    }

    public void duplicateListName(Long id) {
        if (listNameRepository.existsById(id)) {
            // Create new list with today's date as name
            ListName listName = new ListName();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
            listName.setName(LocalDateTime.now().format(formatter));
            // Save new list
            Long newId = listNameRepository.save(listName).getId();
            // Fetch items from the original list
            List<ListItemDTO> existingListItems = listItemRepository.getListItemsByListId(id);
            if (existingListItems != null && !existingListItems.isEmpty()) {
                existingListItems.forEach(item -> {
                    ListItem listItem = new ListItem();
                    ListItemId listItemId = new ListItemId();
                    listItemId.setListId(newId);
                    listItemId.setStoreAisleItemId(item.getId());
                    listItem.setId(listItemId);
                    listItem.setQuantity(item.getDefaultQuantity());
                    listItemRepository.save(listItem);
                });;
            }
        } else {
            log.warn("ListName with id {} not found for duplication", id);
        }
    }

    public void archiveListName(Long id) {
        ListName originalListName = listNameRepository.findById(id).orElse(null);
        if (originalListName != null) {
            originalListName.setIsDeleted(true);
            listNameRepository.save(originalListName);
        } else {
            log.warn("ListName with id {} not found for archiving", id);
        }
    }
}
