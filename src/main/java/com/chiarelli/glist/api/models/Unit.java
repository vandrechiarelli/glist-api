package com.chiarelli.glist.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Unit {
    @Id
    @SequenceGenerator(
            name = "unit_sequence",
            sequenceName = "unit_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "unit_sequence"
    )
    private Long id;
    @Column(nullable = false)
    private String name;
    @OneToMany(mappedBy = "unit")
    @JsonIgnoreProperties("unit")
    private List<Item> item;
}
