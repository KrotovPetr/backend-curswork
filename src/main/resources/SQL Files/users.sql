create table users
(
    id          bigserial
        constraint users_pk
            primary key,
    login       varchar(255),
    "firstName" varchar(255),
    "lastName"  varchar(255),
    role        varchar(30),
    password    varchar(255)
);

alter table users
    owner to postgres;

create unique index users_id_uindex
    on users (id);

