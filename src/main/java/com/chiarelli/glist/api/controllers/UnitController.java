package com.chiarelli.glist.api.controllers;

import com.chiarelli.glist.api.models.Unit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.chiarelli.glist.api.services.UnitService;

import java.util.List;

@RestController
public class UnitController {

    private final UnitService unitService;

    @Autowired
    public UnitController(UnitService unitService) { this.unitService = unitService; }

    @GetMapping("v1/units")
    public ResponseEntity<List<Unit>> getUnits() {
        List<Unit> units = unitService.getUnits();
        return new ResponseEntity<>(units, HttpStatus.OK);
    }

}
