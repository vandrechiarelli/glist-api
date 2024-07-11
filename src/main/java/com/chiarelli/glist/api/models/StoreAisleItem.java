package com.chiarelli.glist.api.models;

import com.chiarelli.glist.api.dtos.StoreAisleItemListDTO;
import com.chiarelli.glist.api.dtos.StoreAisleUrgentItemListDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@NamedNativeQuery(name="StoreAisleItem.getStoreAisleItemList",
                    query="select sai.id as id, sai.item_id as itemId, sai.store_aisle_id as storeAisleId, " +
                            "i.name as itemName, i.translated_name as translatedName, " +
                            "sa.aisle_id as aisleId, a.name as aisleName " +
                            "from store_aisle_item sai " +
                            "inner join item i on sai.item_id = i.id " +
                            "inner join store_aisle sa on sai.store_aisle_id = sa.id " +
                            "inner join aisle a on sa.aisle_id = a.id;",
                    resultSetMapping = "Mapping.StoreAisleItemListDTO")
@SqlResultSetMapping(name = "Mapping.StoreAisleItemListDTO",
                    classes = @ConstructorResult(targetClass = StoreAisleItemListDTO.class,
                                columns = {@ColumnResult(name = "id"),
                                            @ColumnResult(name = "itemId"),
                                            @ColumnResult(name = "storeAisleId"),
                                            @ColumnResult(name = "itemName"),
                                            @ColumnResult(name = "translatedName"),
                                            @ColumnResult(name = "aisleId"),
                                            @ColumnResult(name = "aisleName")}))

@NamedNativeQuery(name="StoreAisleItem.getStoreAisleUrgentItemList",
        query="select li.store_aisle_item_id as itemId, i.name as itemName, " +
                "li.date_created as dateCreated, " +
                "i.duration_days as durationDays, " +
                "(datediff(current_date, li.date_created) - i.duration_days) as dueDays " +
                "from list_item li " +
                "inner join store_aisle_item sai on sai.id = li.store_aisle_item_id " +
                "inner join item i on sai.item_id = i.id " +
                "where (datediff(current_date, li.date_created) - i.duration_days) > 0 order by i.id;",
        resultSetMapping = "Mapping.StoreAisleUrgentItemListDTO")
@SqlResultSetMapping(name = "Mapping.StoreAisleUrgentItemListDTO",
        classes = @ConstructorResult(targetClass = StoreAisleUrgentItemListDTO.class,
                columns = {@ColumnResult(name = "itemId"),
                        @ColumnResult(name = "itemName"),
                        @ColumnResult(name = "dateCreated"),
                        @ColumnResult(name = "durationDays"),
                        @ColumnResult(name = "dueDays")}))

@Entity
@Table
@Getter
@Setter
public class StoreAisleItem {
    @Id
    @SequenceGenerator(
            name = "store_aisle_item_sequence",
            sequenceName = "store_aisle_item_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "store_aisle_item_sequence"
    )
    private Long id;
    private Long storeAisleId;
    private Long itemId;
}
