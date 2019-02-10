insert into category (id, name)
values (1, 'BREAKFAST');

insert into category (id, name)
values (2, 'SNACK');

insert into category (id, name)
values (3, 'LUNCH');

insert into meal (id, name, gluten_presence, category_id)
values(1, 'Oatmeal', 1, 1);

insert into meal (id, name, gluten_presence, category_id)
values(2, 'Almond cookie', 0, 2);