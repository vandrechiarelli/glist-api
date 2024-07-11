package com.chiarelli.glist.api.services;

import com.chiarelli.glist.api.models.ListName;
import com.chiarelli.glist.api.repositories.ListNameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListNameService {

    private final ListNameRepository listNameRepository;

    @Autowired
    public ListNameService(ListNameRepository listNameRepository) {
        this.listNameRepository = listNameRepository;
    }

    public List<ListName> getListNames() {
        return listNameRepository.findAll();
    }

    public void addListNames(ListName listName) {
        listNameRepository.save(listName);
    }
}
