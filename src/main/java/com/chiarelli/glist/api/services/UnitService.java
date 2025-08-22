package com.chiarelli.glist.api.services;

import com.chiarelli.glist.api.models.Unit;
import com.chiarelli.glist.api.repositories.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnitService {

    private final UnitRepository unitRepository;

    @Autowired
    public UnitService(UnitRepository unitRepository) {this.unitRepository = unitRepository;}

    public List<Unit> getUnits() {
        return unitRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }
}
