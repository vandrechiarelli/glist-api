package com.chiarelli.glist.api.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ListItemDTO {
    private Long id;
    private String name;
    private String translatedName;
    private Integer defaultQuantity;
    private Integer durationDays;
    private Long unitId;
    private String unitName;
    private String aisleName;
    private Integer isUrgent;
}
