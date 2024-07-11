package com.chiarelli.glist.api.controllers;

import com.chiarelli.glist.api.models.Item;
import com.chiarelli.glist.api.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("v1/items")
    public List<Item> getItems() {
        return itemService.getItems();
    }

    @GetMapping("v1/item/{id}")
    public Item getItem(@PathVariable Long id) {
        return itemService.getItem(id);
    }

    @PostMapping("v1/item")
    public void newItem(@RequestBody Item item) {
        itemService.newItem(item);
    }

    @PutMapping("v1/item/{id}")
    public void saveItem(@PathVariable Long id, @RequestBody Item item) {
        itemService.saveItem(id, item);
    }
}