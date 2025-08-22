use glist;

-- unit, dozen, package, head, tub
desc unit;
desc unit_sequence;
select * from unit_sequence;
update unit_sequence set next_val = 9 where next_val > 0;
select * from unit;
insert into unit (id, name) values (1, 'unit');
insert into unit (id, name) values (2, 'dozen');
insert into unit (id, name) values (3, 'package');
insert into unit (id, name) values (4, 'head');
insert into unit (id, name) values (5, 'tub');
insert into unit (id, name) values (6, 'can');
insert into unit (id, name) values (7, 'bottle');
insert into unit (id, name) values (8, 'slice');

desc item;
select * from item;
-- alter table item drop column unit;
update item set default_quantity = 1 where id > 0;
update item set default_quantity = 3 where id = 9;
update item set duration_days = 14 where id = 1;
update item set duration_days = 7 where id = 2;
update item set duration_days = 15 where id = 3;
update item set duration_days = 10 where id = 4;
update item set duration_days = 15 where id = 5;
update item set duration_days = 20 where id = 6;
update item set duration_days = 7 where id = 7;
update item set duration_days = 10 where id = 8;
update item set duration_days = 4 where id = 9;
update item set duration_days = 15 where id = 10;
update item set duration_days = 15 where id = 11;
update item set duration_days = 15 where id = 12;
update item set unit_id = 1 where id = 1;
update item set unit_id = 2 where id = 2;
update item set unit_id = 1 where id = 3;
update item set unit_id = 1 where id = 4;
update item set unit_id = 3 where id = 5;
update item set unit_id = 3 where id = 6;
update item set unit_id = 4 where id = 7;
update item set unit_id = 5 where id = 8;
update item set unit_id = 1 where id = 9;
update item set unit_id = 1 where id = 10;

select * from store_aisle_item;

-- StoreAisleItem.getStoreAisleItemList
select sai.id as id, sai.item_id as itemId, sai.store_aisle_id as storeAisleId,
i.name as itemName, i.translated_name as translatedName,
sa.aisle_id as aisleId, a.name as aisleName
from store_aisle_item sai
inner join item i on sai.item_id = i.id
inner join store_aisle sa on sai.store_aisle_id = sa.id
inner join aisle a on sa.aisle_id = a.id;

-- StoreAisleItem.getStoreAisleUrgentItemList
select * from list_name;
select * from item;
select * from store_aisle_item;
select * from list_item;
select li.store_aisle_item_id as itemId, i.name as itemName,
li.date_created as dateCreated,
-- '2024-06-22' as dateCreated,
i.duration_days as durationDays,
(datediff(current_date, li.date_created) - i.duration_days) as dueDays
from list_item li
inner join store_aisle_item sai on sai.id = li.store_aisle_item_id
inner join item i on sai.item_id = i.id
where (datediff(current_date, li.date_created) - i.duration_days) > 0
order by i.id;

-- StoreAisleItem.getStoreAisleUrgentItemList
select * from list_name;
select * from item;
select * from store_aisle_item;
select * from list_item;
select li.store_aisle_item_id as itemId, i.name as itemName,
li.date_created as dateCreated,
-- '2024-06-22' as dateCreated,
i.duration_days as durationDays,
(datediff(current_date, li.date_created) - i.duration_days) as dueDays
from list_item li
inner join store_aisle_item sai on sai.id = li.store_aisle_item_id
inner join item i on sai.item_id = i.id
where (datediff(current_date, li.date_created) - i.duration_days) > 0
order by i.id;

SELECT DATEDIFF('2021-12-25', '2021-01-01') AS 'Days';

select * from aisle;
-- update aisle set name = 'fruits and vegetables' where id = 1;
/*
==> pending add an new aisle
'4','media crema','creme de leite','2','1'
*/

select * from list_name;
-- delete from list_name where id = 2;
select * from list_name_sequence;
update list_name_sequence set next_val = 2 where next_val = 3;
-- update store_aisle_item set store_aisle_id = 3 where id = 5;

select * from store;
select * from store_aisle;
select * from store_aisle_item;
-- update store_aisle_item set store_aisle_id = 3 where id = 5;

select * from list_item;
update list_item set date_created = "2024-06-22 16:57:07.000000";

show tables;