package com.chiarelli.glist.api.repositories;

import com.chiarelli.glist.api.models.StoreAisle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreAisleRepository extends JpaRepository<StoreAisle, Long> {
}
