package com.chiarelli.glist.api.models;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class ListItem {
    @EmbeddedId
    private ListItemId id;
    @Column(nullable = false)
    private Integer quantity;
    @Column(nullable = false)
    private LocalDateTime dateCreated = LocalDateTime.now();
}
