package com.chiarelli.glist.api.services;

import com.chiarelli.glist.api.models.Aisle;
import com.chiarelli.glist.api.repositories.AisleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AisleService {

    private final AisleRepository aisleRepository;

    @Autowired
    public AisleService(AisleRepository aisleRepository) {
        this.aisleRepository = aisleRepository;
    }

    public List<Aisle> getAisles() {
        return aisleRepository.findAll();
    }

    public void addAisles(Aisle aisle) {
        if (aisle.getName().isEmpty()) {
            throw new IllegalStateException("The aisle name is required");
        }
        aisleRepository.save(aisle);
    }
}
