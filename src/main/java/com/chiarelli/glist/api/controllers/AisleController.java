package com.chiarelli.glist.api.controllers;

import com.chiarelli.glist.api.models.Aisle;
import com.chiarelli.glist.api.services.AisleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="v1/aisle")
public class AisleController {
    private final AisleService aisleService;

    @Autowired
    public AisleController(AisleService aisleService) {
        this.aisleService = aisleService;
    }

    @GetMapping
    public List<Aisle> getAisles() {
        return aisleService.getAisles();
    }

    @PostMapping
    public void addAisle(@RequestBody Aisle aisle) {
        aisleService.addAisles(aisle);
    }
}
