create table components
(
    id       bigserial
        constraint components_pk  primary key,
    name    varchar(100) not null,
    type    varchar(100) not null,
    weight  integer not null,
    company varchar(100) not null,
    price   integer not null,
    amount  integer not null,
    count   integer not null,
    image   text not null
);

alter table components
    owner to postgres;

create unique index components_id_uindex
    on components (id);