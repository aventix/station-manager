create table user_profiles(
    id               uuid primary key,
    keycloak_user_id varchar(255) not null unique,
    email            varchar(255) not null,
    created_at       timestamp    not null default now()
);