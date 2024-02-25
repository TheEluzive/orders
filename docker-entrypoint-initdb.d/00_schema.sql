create table category
(
    id   bigserial
        primary key,
    name varchar(255)
);

alter table category
    owner to app;

create table base_product
(
    id                 bigint not null
        primary key,
    name               varchar(255),
    weight             bigint,
    category_entity_id bigint
        constraint category_entity_id_fk
            references category
);

alter table base_product
    owner to app;

create table provider
(
    id   bigserial
        primary key,
    name varchar(255)
);

alter table provider
    owner to app;

create table product_offer
(
    from_date          date,
    price              bigint,
    to_date            date,
    id                 bigint not null
        primary key
        constraint base_entity_id_pk
            references base_product,
    provider_entity_id bigint
        constraint provider_entity_id_fk
            references provider
);

alter table product_offer
    owner to app;

create table receipt
(
    id           bigint not null
        primary key,
    amount       bigint,
    date_receipt date,
    product_id   bigint
        constraint product_id_fk
            references product_offer
);

alter table receipt
    owner to app;



alter sequence category_id_seq owned by category.id;


alter sequence provider_id_seq owned by provider.id;

