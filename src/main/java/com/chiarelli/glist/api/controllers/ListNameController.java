package com.chiarelli.glist.api.controllers;

import com.chiarelli.glist.api.models.ListName;
import com.chiarelli.glist.api.services.ListNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="v1/list_name")
public class ListNameController {

    private final ListNameService listNameService;

    @Autowired
    public ListNameController(ListNameService listNameService) {
        this.listNameService = listNameService;
    }

    @GetMapping
    public List<ListName> getListNames() {
        return listNameService.getListNames();
    }

    @PostMapping
    public void addListNames(@RequestBody ListName listName) {
        listNameService.addListNames(listName);
    }
}
