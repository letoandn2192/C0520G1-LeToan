drop database if exists my_database;
create database my_database;
use my_database;

CREATE TABLE Persons (
    Personid int  auto_increment primary key,
    LastName varchar(255) NOT NULL,
    FirstName varchar(255),
    Age int
);



insert into Persons (LastName, FirstName, Age) values
('Toan', 'Le', 10),
('Hung', 'Le', 11),
('Van', 'Le', 15),
('Tien', 'Le', 16);

select * from Persons;
