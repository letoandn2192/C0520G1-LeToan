drop database if exists my_library;
create database my_library;
use my_library;

create table category (
	category varchar(50) primary key,
    text_description text,
    quantity_in_lib int not null
);

create table student_card (
	student_number_card varchar(15) primary key,
	student_number varchar(15) not null unique,
    student_name varchar(50) not null,
    address text not null,
    email varchar(50) not null,
    image mediumblob
);

create table borrow_order (
	borrow_order_number varchar(15) primary key,
    borrow_date Date,
    required_date Date,
    returned_date Date,
    `status` varchar(15),
    `comment` text,
    student_number_card varchar(15),
    foreign key (student_number_card) references student_card(student_number_card)
);

create table book (
	book_number varchar(15) primary key,
    book_name varchar(50) not null,
    publisher varchar(50) not null,
    author varchar(50) not null,
    publish_year int,
    category varchar(50),
    book_vendor varchar(50) not null,
    book_description mediumtext,
    foreign key (category) references category(category)
);

create table borrow_order_detail (
	book_number varchar(15),
    borrow_order_number varchar(15),
    primary key (book_number, borrow_order_number),
    foreign key (book_number) references book(book_number),
    foreign key (borrow_order_number) references borrow_order(borrow_order_number)
);