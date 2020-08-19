/*Bước 1: Tạo cơ sở dữ liệu demo*/
drop database if exists my_product;
create database my_product;
use my_product;

/*Bước 2: Tạo bảng Products với các trường dữ liệu:*/
create table product (
	id int auto_increment primary key,
    product_code varchar(15) not null,
    product_name varchar(50) not null,
    product_price decimal(10,2) not null,
    product_amount int not null,
    product_description text,
    product_status varchar(50)
);

/*Chèn một số dữ liệu mẫu cho bảng Product*/
insert into product (product_code, product_name, product_price, product_amount, product_description, product_status) 
values
('C0001', 'Chupa Chups', 100, 1000, 'candy sweet', 'available'),
('B0001', 'Oreo', 150, 500, 'biscuit crunchy', 'available'),
('C0002', 'Chip Chip', 50, 200, 'mashmallow yummy', 'out of stock'),
('B0011', 'Custard', 200, 70, 'custard cake', 'available'),
('C0045', 'Doublemints',10, 60, 'mints', 'available'),
('C0101', 'Mentos', 15, 130, 'mentos', 'available'),
('B0010', 'Kit Kat', 10, 100, 'cheesecake', 'available');

select *
from product;

/*Bước 3:
Tạo Unique Index trên bảng Products (sử dụng cột productCode để tạo chỉ mục)
Tạo Composite Index trên bảng Products (sử dụng 2 cột productName và productPrice)
Sử dụng câu lệnh EXPLAIN để biết được câu lệnh SQL của bạn thực thi như nào
So sánh câu truy vấn trước và sau khi tạo index*/

-- Trước khi tạo index
explain select *
from product
where product_code = 'C0045';

create index idx_product_code on product(product_code);

-- Sau khi tạo index 
explain select *
from product
where product_code = 'C0045';

drop index idx_product_code on product;

-- Trước khi tạo index
explain select *
from product
where product_name = 'Custard'
	and product_price = 200;

alter table product
add index idx_name_price(product_name, product_price);

-- Sau khi tạo index
explain select *
from product
where product_name = 'Custard'
	and product_price = 200;
    
drop index idx_name_price on product;

/*Bước 4:*/
-- Tạo view lấy về các thông tin: productCode, productName, productPrice, productStatus từ bảng products.
create view product_info as
select product_code, product_name, product_price, product_status
from product;

select * from product_info;

-- Tiến hành sửa đổi view
alter view product_info as
select id, product_code, product_name, product_price, product_status
from product;

select * from product_info;

-- Tiến hành xoá view*/
drop view product_info;

-- Bước 5: (check file procedurc.sql)
call my_product.get_product_information();

call my_product.add_new_product('B0015', 'ChocoPie', 70, 100, 'chocolate cake', 'available');

select *
from product;

call my_product.edit_price_product(1, 110);

select *
from product;

call delete_product(8);

select *
from product;