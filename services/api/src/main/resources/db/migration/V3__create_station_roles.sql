create table station_roles
(
    id         uuid primary key,
    station_id uuid         not null,
    name       varchar(100) not null,
    created_at timestamp    not null default now(),

    constraint fk_station_roles_station
        foreign key (station_id) references stations (id),

    constraint uk_station_roles_station_name
        unique (station_id, name)
);