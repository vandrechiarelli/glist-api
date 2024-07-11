package com.chiarelli.glist.api.controllers;

import com.chiarelli.glist.api.models.ListItem;
import com.chiarelli.glist.api.services.ListItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ListItemController {

    private final ListItemService listItemService;

    @Autowired
    public ListItemController(ListItemService listItemService) {
        this.listItemService = listItemService;
    }

    @GetMapping(path="v1/list_items")
    public List<ListItem> getListItems() {
        return listItemService.getListItems();
    }

    @GetMapping(path="v1/list_item/{listId}")
    public List<ListItem> getListItems(@PathVariable Long listId) {
        return listItemService.getListItemsByListId(listId);
    }

    @GetMapping(path="v1/list_item/{listId}/{storeAisleItemId}")
    public ListItem getListItem(@PathVariable Long listId, @PathVariable Long storeAisleItemId) {
        return listItemService.getListItem(listId, storeAisleItemId);
    }

    @PostMapping(path="v1/list_item")
    public void newListItem(@RequestBody ListItem listItem) {
        listItemService.newListItem(listItem);
    }

    @PutMapping(path="v1/list_item/{listId}/{storeAisleItemId}")
    public void saveListItem(@PathVariable Long listId, @PathVariable Long storeAisleItemId, @RequestBody ListItem listItem){
        listItemService.saveListItem(listId, storeAisleItemId, listItem);
    }
}
