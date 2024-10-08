package com.chiarelli.glist.api.controllers;

import com.chiarelli.glist.api.models.Item;
import com.chiarelli.glist.api.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Item>> getItems() {
        return new ResponseEntity<>(itemService.getItems(), HttpStatus.OK);
    }

    @GetMapping("v1/item/{id}")
    public ResponseEntity<Item> getItem(@PathVariable Long id) {
        Item item = itemService.getItem(id);
        return new ResponseEntity<>(item, item != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @PostMapping("v1/item")
    public void newItem(@RequestBody Item item) {
        itemService.newItem(item);
    }

    @PutMapping("v1/item/{id}")
    public ResponseEntity<Long> saveItem(@PathVariable Long id, @RequestBody Item item) {
        Long existingId = itemService.saveItem(id, item);
        return new ResponseEntity<>(existingId, existingId != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("v1/item/{id}")
    public ResponseEntity<Long> deleteItem(@PathVariable Long id) {
        Long existingId = itemService.deleteItem(id);
        return new ResponseEntity<>(existingId, existingId != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}