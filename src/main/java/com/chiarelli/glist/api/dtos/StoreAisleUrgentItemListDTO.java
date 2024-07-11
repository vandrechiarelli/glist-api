package com.chiarelli.glist.api.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Builder
@Getter
@Setter
public class StoreAisleUrgentItemListDTO {
    private Long itemId;
    private String itemName;
    private Timestamp dateCreated;
    private Integer durationDays;
    private Long dueDays;
}
