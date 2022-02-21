-- удаление всех таблиц
DROP TABLE workouts;
DROP TABLE sneakers;
DROP TABLE models;
DROP TABLE producers;
-- DROP TABLE runners;
-- DROP TABLE user_role;
-- DROP TABLE users;

-- создание таблицы производителя кроссовок. Содержит сведения о названии фирмы-производителя
create table producers (
    id int serial default value,
    name varchar(20),
    primary key (id)
);

create table models (
    id int serial default value,
    name varchar(20),
    limitation int,
    description text,
    producer_id int not null,
    primary key (id),
    foreign key (producer_id) references producers(id)
);

-- создание таблицы модели кроссовок. Содержит информацию о названии модели,
-- версии, описании.

create table sneakers (
    id int serial default value,
    pair_number int,
    enable boolean default true,
    note text,
    model_id int not null ,
    account_id int not null ,
    primary key(id),
    foreign key (model_id) references models(id),
    foreign key (account_id) references accounts(id)
);

-- создание таблицы для связи бегунов и кроссовок. Содержит информацию о том,
-- какие у бегуна есть кроссовки и номера пар(если убегуна есть несколько пар одинаковых),
-- для того чтобы отслеживать статистику по каждой паре.Если поле termination равно 1, то
-- кроссовки еще действуют, если нет, то в топку их.


-- создание таблицы тренировок. Содержит информацию о дате тренировки, времени, преодоленной
-- дистанции, самочувствии от 1 до 5, где 1 - было тяжело, было легко(сделать в виде
-- рейтинга из звезд или смайликов).
CREATE TABLE workouts (
    id int serial default value,
    day_run datetime default current_timestamp,
    distance_in_metres int,
    time_in_seconds int,
    health int(1) default 3,
    sneakers_id int not null ,
    primary key (id),
    foreign key (sneakers_id) references sneakers(id)
);

-- заполенние таблицы производителей кроссовок
insert into producers (name) values ('New Balance');
insert into producers (name) values ('Saucony');
insert into producers (name) values ('Hoka');
insert into producers (name) values ('Nike');


-- заполение таблицы моделей кроссовок
insert into models(name, limitation, description, producer_id)
VALUES ('NB 1080', 600, 'для тренировок', 1);
insert into models(name, limitation, description, producer_id)
VALUES ('Saucony trail', 670, 'для трейла', 2);
insert into models(name, limitation, description, producer_id)
VALUES ('Hoka S4', 900, 'для быстрого бега', 3);
insert into models(name, limitation, description, producer_id)
VALUES ('Nike One', 400, 'для соревнований', 4);
insert into models(name, limitation, description, producer_id)
VALUES ('NB 890', 800, 'для тренировок', 1);

-- заполнение таблицы фактических пар кроссовок
insert into sneakers (pair_number, enable, note, model_id, account_id)
VALUES (1, true, 'бегаю каждый день', 1, 4);
insert into sneakers (pair_number, enable, note, model_id, account_id)
VALUES (1, true, 'бегаю каждый день', 2, 4);
insert into sneakers (pair_number, enable, note, model_id, account_id)
VALUES (1, true, 'бегаю каждый день', 3, 5);
insert into sneakers (pair_number, enable, note, model_id, account_id)
VALUES (1, true, 'бегаю каждый день', 4, 5);
insert into sneakers (pair_number, enable, note, model_id, account_id)
VALUES (1, true, 'бегаю каждый день', 5, 4);
insert into sneakers (pair_number, enable, note, model_id, account_id)
VALUES (1, true, 'бегаю каждый день', 5, 5);

-- заполнение таблицы тренировок
insert into workouts (distance_in_metres, time_in_seconds, health, sneakers_id)
VALUES (15000, 3600, 3, 1);
insert into workouts (distance_in_metres, time_in_seconds, health, sneakers_id)
VALUES (20000, 4500, 2, 2);
insert into workouts (distance_in_metres, time_in_seconds, health, sneakers_id)
VALUES (10000, 2400, 1, 3);
insert into workouts (distance_in_metres, time_in_seconds, health, sneakers_id)
VALUES (12000, 3600, 4, 4);

