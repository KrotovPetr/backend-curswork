create table spring_session
(
    primary_id            char(36) not null
        constraint spring_session_pk
            primary key,
    session_id            char(36) not null,
    creation_time         bigint   not null,
    last_access_time      bigint   not null,
    max_inactive_interval integer  not null,
    expiry_time           bigint   not null,
    principal_name        varchar(100)
);

alter table spring_session
    owner to postgres;

create unique index spring_session_ix1
    on spring_session (session_id);

create index spring_session_ix2
    on spring_session (expiry_time);

create index spring_session_ix3
    on spring_session (principal_name);

