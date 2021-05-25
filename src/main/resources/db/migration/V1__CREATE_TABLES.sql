drop table if exists order_detail_entity CASCADE;
drop table if exists order_entity CASCADE;
drop table if exists product_entity CASCADE;
create table order_detail_entity (
       id bigint not null,
        quantity bigint,
        order_entity_id bigint,
        product_entity_id bigint,
        primary key (id)
    );
create table order_entity (
       id bigint not null,
        customer_name varchar(255),
        signed_date varchar(255),
        primary key (id)
    );
create table product_entity (
       id bigint not null,
        price double,
        product_name varchar(255),
        primary key (id)
);

alter table order_detail_entity
       add constraint FKh8h5oqjblx8m1iaj30039rx84
       foreign key (order_entity_id)
       references order_entity;

alter table order_detail_entity
       add constraint FKf0pl306xy1i0icmdfir4m7c80
       foreign key (product_entity_id)
       references product_entity;

insert
    into
        product_entity
        (price, product_name, id)
    values
        (10.0, 'Product 1', 1);

insert
    into
        product_entity
        (price, product_name, id)
    values
        (20.0, 'Product 2', 2);

insert
    into
        product_entity
        (price, product_name, id)
    values
        (15.0, 'Product 3', 3);

insert
    into
        order_entity
        (customer_name, signed_date, id)
    values
        ('Customer 1', '10-20-2019', 101);

insert
    into
        order_entity
        (customer_name, signed_date, id)
    values
        ('Customer 2', '01-01-2020', 102);
insert
    into
        order_detail_entity
        (order_entity_id, product_entity_id, quantity, id)
    values
        (101, 1, 2, 201);

insert
    into
        order_detail_entity
        (order_entity_id, product_entity_id, quantity, id)
    values
        (101, 2, 4, 202);

insert
    into
        order_detail_entity
        (order_entity_id, product_entity_id, quantity, id)
    values
        (102, 1, 3, 203);

insert
    into
        order_detail_entity
        (order_entity_id, product_entity_id, quantity, id)
    values
        (102, 3, 5, 204);
