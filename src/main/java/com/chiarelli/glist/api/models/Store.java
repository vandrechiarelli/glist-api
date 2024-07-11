package com.chiarelli.glist.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table
@Getter
@Setter
public class Store {
    @Id
    @SequenceGenerator(
            name = "store_sequence",
            sequenceName = "store_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "store_sequence"
    )
    private Long id;
    @Column(nullable = false)
    private String name;
    private String address;
    @OneToMany(mappedBy = "store")
    @JsonIgnoreProperties("store")
    private List<StoreAisle> storeAisle;
}
