package com.chiarelli.glist.api.repositories;

import com.chiarelli.glist.api.models.ListName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListNameRepository extends JpaRepository<ListName, Long> {
}
