drop database if exists my_database;
create database my_database;
use my_database;

create table test (
	id int not null,
    `name` varchar(50) not null,
    age int not null,
    course varchar(50) not null,
    amount int
);

insert into test (id, `name`, age, course, amount) values
(1, 'Hoang', 21, 'CNTT', 400000),
(2, 'Viet', 19, 'DTVT', 320000),
(3, 'Thanh', 18, 'KTDN', 400000),
(4, 'Nhan', 19, 'TCNH', 450000),
(5, 'Huong', 20, 'CNTT', 500000),
(5, 'Huong', 20, 'CNTT', 200000);

select * from test;

/*Viết câu lệnh hiện thị tất cả các dòng có tên là Huong*/
select * from test
where `name` = 'Huong';

/*Viết câu lệnh lấy ra tổng số tiền của Huong*/
select id, `name` , sum(amount) from test
where `name` = 'Huong'; 

/*- Viết câu lệnh lấy ra tên danh sách của tất cả học viên, không trùng lặp*/
select distinct(`name`) from test;
