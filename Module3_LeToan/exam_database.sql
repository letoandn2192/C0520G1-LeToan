drop database if exists exam_database;
create database exam_database;
use exam_database;

create table category
(
	category_id int auto_increment primary key,
    category_name varchar(50)
);

create table product
(
	product_id int auto_increment primary key,
	product_name varchar(50),
    product_price double,
    product_amount int,
    product_color varchar(50),
    product_description text,
    product_category_id int,
    foreign key (product_category_id) references category(category_id)
);

insert into category (category_name)
values
('Phone'),
('Television'),
('Camera'),
('Laptop');


insert into product (product_name, product_price, product_amount, product_color, product_description, product_category_id)
values
('Iphone X', 1000, 10, 'Red', 'Luxury', 1),
('Samsung Note 10', 1100, 20, 'Black', 'Luxury', 1),
('Dell 4N511', 2500, 15, 'Silver', 'Luxury', 4);

select * from category;
select * from product;