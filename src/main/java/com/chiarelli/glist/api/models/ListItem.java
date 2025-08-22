package com.chiarelli.glist.api.models;

import com.chiarelli.glist.api.dtos.ListItemDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@NamedNativeQuery(name="ListItem.getListItems",
        query="select li.store_aisle_item_id as id, i.name as name, " +
                "i.translated_name as translatedName, i.default_quantity as defaultQuantity, " +
                "i.duration_days as durationDays, u.id as unitId, " +
                "u.name as unitName, a.name as aisleName, " +
                "(case when datediff(current_date, li.date_created) > i.duration_days then true else false end) as isUrgent " +
                "from list_item li " +
                "inner join store_aisle_item sai on sai.id = li.store_aisle_item_id " +
                "inner join item i on sai.item_id = i.id " +
                "inner join unit u on i.unit_id = u.id " +
                "inner join store_aisle sa on sai.store_aisle_id = sa.id " +
                "inner join aisle a on sa.aisle_id = a.id " +
                "order by sa.aisle_order, i.name;",
        resultSetMapping = "Mapping.ListItemDTO")
@SqlResultSetMapping(name = "Mapping.ListItemDTO",
        classes = @ConstructorResult(targetClass = ListItemDTO.class,
                columns = {@ColumnResult(name = "id"),
                        @ColumnResult(name = "name"),
                        @ColumnResult(name = "translatedName"),
                        @ColumnResult(name = "defaultQuantity"),
                        @ColumnResult(name = "durationDays"),
                        @ColumnResult(name = "unitId"),
                        @ColumnResult(name = "unitName"),
                        @ColumnResult(name = "aisleName"),
                        @ColumnResult(name = "isUrgent")}))

@NamedNativeQuery(name="ListItem.getListItemsByListId",
        query="select li.store_aisle_item_id as id, i.name as name, " +
                "i.translated_name as translatedName, i.default_quantity as defaultQuantity, " +
                "i.duration_days as durationDays, u.id as unitId, " +
                "u.name as unitName, a.name as aisleName, " +
                "(case when datediff(current_date, li.date_created) > i.duration_days then true else false end) as isUrgent " +
                "from list_item li " +
                "inner join store_aisle_item sai on sai.id = li.store_aisle_item_id " +
                "inner join item i on sai.item_id = i.id " +
                "inner join unit u on i.unit_id = u.id " +
                "inner join store_aisle sa on sai.store_aisle_id = sa.id " +
                "inner join aisle a on sa.aisle_id = a.id " +
                "where li.list_id = ?1 " +
                "order by sa.aisle_order, i.name;",
        resultSetMapping = "Mapping.ListItemDTO")
@SqlResultSetMapping(name = "Mapping.ListItemDTO.ByListId",
        classes = @ConstructorResult(targetClass = ListItemDTO.class,
                columns = {@ColumnResult(name = "id"),
                        @ColumnResult(name = "name"),
                        @ColumnResult(name = "translatedName"),
                        @ColumnResult(name = "defaultQuantity"),
                        @ColumnResult(name = "durationDays"),
                        @ColumnResult(name = "unitId"),
                        @ColumnResult(name = "unitName"),
                        @ColumnResult(name = "aisleName"),
                        @ColumnResult(name = "isUrgent")}))

@NamedNativeQuery(name="ListItem.getListAvailableItems",
        query="select i.id as id, i.name as name, " +
                "i.translated_name as translatedName, i.default_quantity as defaultQuantity, " +
                "i.duration_days as durationDays, u.id as unitId, u.name as unitName, a.name as aisleName, " +
                "(case when datediff(current_date, i.last_purchased_date) > i.duration_days then true else false end) as isUrgent " +
                "from item as i " +
                "inner join store_aisle_item sai on sai.item_id = i.id " +
                "inner join store_aisle sa on sai.store_aisle_id = sa.id " +
                "inner join aisle a on sa.aisle_id = a.id " +
                "left join unit as u on u.id = i.unit_Id " +
                "left join list_item as li on li.store_aisle_item_id = sai.id and li.list_id = 1 " +
                "where li.store_aisle_item_id is null " +
                "order by i.name;",
        resultSetMapping = "Mapping.ListItemDTO")
@SqlResultSetMapping(name = "Mapping.ListItemDTO.ByListIdAvailableItems",
        classes = @ConstructorResult(targetClass = ListItemDTO.class,
                columns = {@ColumnResult(name = "id"),
                        @ColumnResult(name = "name"),
                        @ColumnResult(name = "translatedName"),
                        @ColumnResult(name = "defaultQuantity"),
                        @ColumnResult(name = "durationDays"),
                        @ColumnResult(name = "unitId"),
                        @ColumnResult(name = "unitName"),
                        @ColumnResult(name = "aisleName"),
                        @ColumnResult(name = "isUrgent")}))

@Entity
@Getter
@Setter
public class ListItem {
    @EmbeddedId
    private ListItemId id;
    @Column(nullable = false)
    private Integer quantity;
    @Column(nullable = false)
    private LocalDateTime dateCreated = LocalDateTime.now();
    @Column(nullable = false)
    private Boolean isDeleted = false;
}
