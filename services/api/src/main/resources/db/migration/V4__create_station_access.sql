create table station_access
(
    id         uuid primary key,
    user_id    uuid      not null,
    station_id uuid      not null,
    role_id    uuid      not null,
    created_at timestamp not null default now(),

    constraint fk_station_access_user
        foreign key (user_id) references user_profiles (id),

    constraint fk_station_access_station
        foreign key (station_id) references stations (id),

    constraint fk_station_access_role
        foreign key (role_id) references station_roles (id),

    constraint uk_station_access_user_station
        unique (user_id, station_id)
);