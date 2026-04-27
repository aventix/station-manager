create table stations (
    id uuid primary key,
    name varchar(255) not null,
    debtor_number varchar(8) not null unique,
    station_number varchar(8) not null unique,
    address varchar(500) not null,
    phone_number varchar(100),
    active boolean not null default true,
    created_at timestamp not null default now(),
    updated_at timestamp not null default now());