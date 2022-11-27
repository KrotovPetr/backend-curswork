create table orders
(
    id         bigserial
        constraint orders_pk
            primary key,
    price      integer not null,
    email      varchar(100) not null,
    components text not null,
    number     integer not null
);

alter table orders
    owner to postgres;

create unique index orders_id_uindex
    on orders (id);

