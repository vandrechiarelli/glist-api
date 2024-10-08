package com.chiarelli.glist.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class StoreAisle {
    @Id
    @SequenceGenerator(
            name = "store_aisle_sequence",
            sequenceName = "store_aisle_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "store_aisle_sequence"
    )
    @Column(insertable = false, updatable = false)
    private Long id;
    private Long storeId;
    @ManyToOne
    @JoinColumn(name = "storeId", insertable = false, updatable = false)
    @JsonIgnoreProperties("storeAisle")
    private Store store;
    private Long aisleId;
    @ManyToOne
    @JoinColumn(name = "id", insertable = false, updatable = false)
    @JsonIgnoreProperties("storeAisle")
    private Aisle aisle;
    private Long aisleOrder;
}
