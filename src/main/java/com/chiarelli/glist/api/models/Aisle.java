package com.chiarelli.glist.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Aisle {
    @Id
    @SequenceGenerator(
            name = "aisle_sequence",
            sequenceName = "aisle_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "aisle_sequence"
    )
    private Long id;
    private String name;
    @OneToMany(mappedBy = "aisle")
    @JsonIgnoreProperties("aisle")
    private List<StoreAisle> storeAisle;
}
