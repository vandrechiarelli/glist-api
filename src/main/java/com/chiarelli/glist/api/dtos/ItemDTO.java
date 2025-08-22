package com.chiarelli.glist.api.dtos;

import com.chiarelli.glist.api.models.Item;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ItemDTO {
    private Long id;
    private String name;
    private String translatedName;
    private Integer defaultQuantity;
    private Integer durationDays;
    private LocalDateTime lastPurchasedDate;
    private Long unitId;
    private String unitName;
    private Integer isUrgent;

    public ItemDTO(Item item) {
        this.id = item.getId();
        this.name = item.getName();
        this.translatedName = item.getTranslatedName();
        this.defaultQuantity = item.getDefaultQuantity();
        this.durationDays = item.getDurationDays();
        this.lastPurchasedDate = item.getLastPurchasedDate();
        this.unitId = item.getUnit().getId();
        this.unitName = item.getUnit().getName();
    }
}
