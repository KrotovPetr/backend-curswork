create table orders
(
    id         bigserial
        constraint orders_pk
            primary key,
    price      integer,
    email      varchar(100),
    components text,
    number     integer
);

alter table orders
    owner to postgres;

create unique index orders_id_uindex
    on orders (id);

