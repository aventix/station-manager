create table permission_definitions
(
    id          uuid primary key,
    key         varchar(150) not null unique,
    description varchar(255) not null
);

create table station_role_permissions
(
    id            uuid primary key,
    role_id       uuid not null,
    permission_id uuid not null,

    constraint fk_station_role_permissions_role
        foreign key (role_id) references station_roles (id),

    constraint fk_station_role_permissions_permission
        foreign key (permission_id) references permission_definitions (id),

    constraint uk_station_role_permissions_role_permission
        unique (role_id, permission_id)
);