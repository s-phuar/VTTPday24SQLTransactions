use vttp_2025;

drop table orders;
drop table order_details;

#when inserting data, insert into parent first(orders) before inserting into order_details  

create table orders(
	order_id int not null auto_increment,
    order_date date,
    customer_name varchar(128),
    ship_address varchar(128),
    notes text,
    tax decimal(3,2) default 0.05,
    constraint pk_order_id primary key(order_id)
);

insert into orders (order_date, customer_name, ship_address, notes, tax) values ('2025-01-22', 'Samuel', '25 Ship Lane', 'do not be late', 0.06);
insert into orders (order_date, customer_name, ship_address, notes) values ('2025-01-23', 'Samuel', '25 Ship Lane', 'do not be late');

select * from orders;
describe orders;
select * from order_details;
-- delete from orders where order_id=4;

create table order_details(
	id int not null auto_increment,
    order_id int not null,
    product varchar(64),
    unit_price decimal(3,2),
    discount decimal(3,2) default 1.0,
    quantity int,
    constraint pk_id primary key(id),
    constraint fk_id foreign key(order_id) references orders(order_id)
);

insert into order_details (order_id, product, unit_price, discount, quantity) values (?, 'Widget', 24.99, 1.00, 1);

