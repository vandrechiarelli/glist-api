package com.chiarelli.glist.api.controllers;

import com.chiarelli.glist.api.models.ListName;
import com.chiarelli.glist.api.services.ListNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ListNameController {

    private final ListNameService listNameService;

    @Autowired
    public ListNameController(ListNameService listNameService) {
        this.listNameService = listNameService;
    }

    @GetMapping("v1/list_name")
    public ResponseEntity<List<ListName>> getListNames() {
        return new ResponseEntity<>(listNameService.getListNames(), HttpStatus.OK);
    }

    @GetMapping("v1/list_name/{id}")
    public ResponseEntity<ListName> getListName(@PathVariable Long id) {
        ListName listName = listNameService.getListName(id);
        return new ResponseEntity<>(listName, listName != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @PostMapping("v1/list_name")
    public void addListNames(@RequestBody ListName listName) {
        listNameService.newListName(listName);
    }

    @PostMapping("v1/list_name/{id}/duplicate")
    public void duplicateListNames(@PathVariable Long id) {
        listNameService.duplicateListName(id);
    }

    @PostMapping("v1/list_name/{id}/archive")
    public void archiveListNames(@PathVariable Long id) {
        listNameService.archiveListName(id);
    }

    @PutMapping("v1/list_name/{id}")
    public ResponseEntity<Long> saveListName(@PathVariable Long id, @RequestBody ListName listName) {
        Long existingId = listNameService.saveListName(id, listName);
        return new ResponseEntity<>(existingId, existingId != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
