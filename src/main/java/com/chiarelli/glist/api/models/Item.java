package com.chiarelli.glist.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Item {
    @Id
    @SequenceGenerator(
            name = "item_sequence",
            sequenceName = "item_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "item_sequence"
    )
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String translatedName;
    @Column(nullable = false)
    private Integer defaultQuantity;
    @Column(nullable = false)
    private Integer durationDays;
    private Long unitId;
    @ManyToOne
    @JoinColumn(name = "unitId", insertable = false, updatable = false)
    @JsonIgnoreProperties("item")
    private Unit unit;
}
