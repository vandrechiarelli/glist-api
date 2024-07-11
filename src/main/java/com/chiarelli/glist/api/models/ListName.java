package com.chiarelli.glist.api.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table
@Getter
@Setter
public class ListName {
    @Id
    @SequenceGenerator(
            name = "list_name_sequence",
            sequenceName = "list_name_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "list_name_sequence"
    )
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private LocalDateTime dateCreated = LocalDateTime.now();
}
