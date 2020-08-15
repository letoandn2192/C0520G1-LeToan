drop database if exists my_database;
create database my_database;
use my_database;
create table Customers (
	customer_number int primary key,
	full_name varchar(255) not null,
	address varchar(255),
	email varchar(255) unique,
    phone varchar(255) unique
);

create table Accounts (
	account_number int primary key,
    account_type varchar(255),
    `date` date,
    balance double,
    customer_number int,
    foreign key (customer_number) references Customers(customer_number)
);

create table Transactions (
	tran_number int primary key,
	account_number int,
    `date` Date,
    amounts double,
    descriptions varchar(255),
    foreign key (account_number) references Accounts(account_number)
);