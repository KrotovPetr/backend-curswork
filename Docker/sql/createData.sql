CREATE SEQUENCE IF NOT EXISTS users_id_seq
    INCREMENT 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    START 1
    CACHE 1;
ALTER SEQUENCE users_id_seq OWNER TO admin;

CREATE SEQUENCE IF NOT EXISTS orders_id_seq
    INCREMENT 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    START 1
    CACHE 1;
ALTER SEQUENCE orders_id_seq OWNER TO admin;

CREATE SEQUENCE IF NOT EXISTS components_id_seq
    INCREMENT 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    START 1
    CACHE 1;
ALTER SEQUENCE components_id_seq OWNER TO admin;


CREATE TABLE IF NOT EXISTS users
(
     id         bigserial
         constraint users_pk
             primary key,
     username   varchar(255) not null,
     password   varchar(255) not null,
     first_name varchar(255) not null,
     last_name  varchar(255) not null,
     role       varchar(255) not null,
     is_active  boolean      not null

);

ALTER TABLE users OWNER TO admin;

ALTER SEQUENCE users_id_seq OWNED BY users.id;

CREATE TABLE IF NOT EXISTS components
(

        id      bigserial
            constraint components_pk
                primary key,
        name    varchar(100),
        type    varchar(100),
        weight  integer,
        company varchar(100),
        price   integer,
        amount  integer,
        count   integer,
        image   text

);

ALTER TABLE components OWNER TO admin;

ALTER SEQUENCE components_id_seq OWNED BY components.id;

CREATE TABLE IF NOT EXISTS orders
(

     id         bigserial
         constraint orders_pk
             primary key,
     price      integer,
     email      varchar(100),
     components text,
     number     integer

);

ALTER TABLE orders OWNER TO admin;

ALTER SEQUENCE orders_id_seq OWNED BY orders.id;
-- {
--     "name": "Молоток22",
--     "type": "instrument",
--     "weight": 1000,
--     "company": "RusMetall",
--     "price": 1000,
--     "amount": 1,
--     "image":"AAA",
--     "count": 1
-- }