drop database if exists my_database;
create database my_database;
use my_database;

CREATE TABLE persons (
    person_id int  auto_increment primary key,
    last_name varchar(255) NOT NULL,
    first_name varchar(255),
    age int
);

insert into persons (last_name, first_name, age) values
('Toan', 'Le', 10),
('Hung', 'Le', 11),
('Van', 'Le', 15),
('Tien', 'Le', 16);

select * from persons;
