package com.chiarelli.glist.api.models;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Embeddable
public class ListItemId implements Serializable {
    private Long listId;
    private Long storeAisleItemId;
}
