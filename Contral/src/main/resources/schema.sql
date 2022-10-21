
create table users
(
    username char(20),
    email char(20)
    login char(20),
    password char(20)
);

create table history
(
    id serial primary key,
    user_name char(20),
    city char(20),
    time date()
);

insert into history (user_name, city)
values ('Карина', 'Kazan'),
       ('Дмитрий', 'Иркутск'),
       ('Вероника', 'Екатеринбург'),
       ('Алина', 'Москва'),
       ('Егор','Москва'),
       ('Алексей', 'Kazan'),
       ('Артем', 'Иркутск'),
       ('Кирилл', 'Екатеринбург'),
       ('Арина', 'Москва'),
       ('Саша','Москва')