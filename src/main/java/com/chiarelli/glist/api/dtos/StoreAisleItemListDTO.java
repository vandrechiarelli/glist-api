package com.chiarelli.glist.api.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class StoreAisleItemListDTO {
    private Long id;
    private Long itemId;
    private Long storeAisleId;
    private String itemName;
    private String translatedName;
    private Long aisleId;
    private String aisleName;
//    private String aisleName;
//    private Long itemId;
//    private Long itemName;
}
