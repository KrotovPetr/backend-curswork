create table components
(
    id      bigint,
    name    varchar(100),
    type    varchar(100),
    weight  integer,
    company varchar(100),
    price   integer,
    amount  integer,
    count   integer,
    image   text
);

alter table components
    owner to postgres;

