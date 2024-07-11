package com.chiarelli.glist.api.services;

import com.chiarelli.glist.api.models.Item;
import com.chiarelli.glist.api.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> getItems() {
        return itemRepository.findAll();
    }

    public Item getItem(Long id) {
        return itemRepository.findById(id)
                .orElse(null);
    }

    public void newItem(Item item) {
        itemRepository.save(item);
    }

    public void saveItem(Long id, Item item) {
        item.setId(id);
        itemRepository.save(item);
    }
}
