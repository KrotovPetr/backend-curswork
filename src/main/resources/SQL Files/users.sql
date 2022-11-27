create table users
(
    id          bigserial
        constraint users_pk
            primary key,
    login       varchar(255) not null,
    "firstName" varchar(255) not null,
    "lastName"  varchar(255) not null,
    role        varchar(30) not null,
    password    varchar(255) not null
);

alter table users
    owner to postgres;

create unique index users_id_uindex
    on users (id);

