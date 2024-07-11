package com.chiarelli.glist.api.repositories;

import com.chiarelli.glist.api.models.Aisle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AisleRepository extends JpaRepository<Aisle, Long> {
}
