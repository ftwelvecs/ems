-- users, addresses, departments, positions, regions

create schema main;

create sequence main.users_s;

create table main.users
(
    id               bigint primary key default nextval('main.users_s'),
    username         varchar(255) unique not null,
    password         varchar(1000)       not null,
    first_name       varchar(255)        not null,
    last_name        varchar(255),
    patronymic       varchar(255),
    email            varchar(255) unique not null,
    is_active        varchar(1)         default 'Y',
    create_date      timestamp          default current_timestamp,
    last_update_date timestamp
);

-- примеры комментирования:
-- comment on table main.users is 'Таблица пользователей';
-- comment on column main.users.username is 'поле для логина пользователя';
-- comment on column main.users.password is 'поле для пароля пользователя';


create sequence main.addresses_s;

create table main.addresses
(
    id               bigint primary key default nextval('main.addresses_s'),
    city             varchar(255) not null,
    address          varchar(255) not null,
    create_date      timestamp          default current_timestamp,
    last_update_date timestamp
);

create sequence main.departments_s;

create table main.departments
(
    id               bigint primary key default nextval('main.departments_s'),
    name             varchar(255) not null,
    create_date      timestamp,
    last_update_date timestamp
);

create sequence main.positions_s;

create table main.positions
(
    id               bigint primary key default nextval('main.positions_s'),
    name             varchar(255) not null,
    create_date      timestamp,
    last_update_date timestamp
);

create sequence main.regions_s;

create table main.regions
(
    id               bigint primary key default nextval('main.regions_s'),
    name             varchar(255) not null,
    create_date      timestamp,
    last_update_date timestamp
);

create table main.users_addresses
(
    user_id    bigint references main.users (id),
    address_id bigint references main.addresses (id),
    primary key (user_id, address_id)
);

create table main.users_departments
(
    user_id       bigint references main.users (id),
    department_id bigint references main.departments (id),
    primary key (user_id, department_id)
);

create table main.users_positions
(
    user_id     bigint references main.users (id),
    position_id bigint references main.positions (id),
    primary key (user_id, position_id)
);

create table main.users_regions
(
    user_id   bigint references main.users (id),
    region_id bigint references main.regions (id),
    primary key (user_id, region_id)
);
