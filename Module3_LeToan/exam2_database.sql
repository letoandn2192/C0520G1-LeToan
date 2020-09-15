drop database if exists exam2_database;
create database exam2_database;
use exam2_database;

create table complex
(
	complex_id varchar(50) primary key,
    complex_status varchar(50),
    complex_area double,
    complex_floor int,
    complex_type varchar(50),
    complex_cost double,
    complex_start_date date,
    complex_end_date date
);

insert into complex (complex_id, complex_status, complex_area, complex_floor, complex_type, complex_cost, complex_start_date, complex_end_date)
values
('111-11-11', 'Empty', 200, 10, 'Share Office', 1000, '2019-10-10', '2020-10-10');