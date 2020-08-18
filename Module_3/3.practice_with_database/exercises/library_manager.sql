drop database if exists my_library;
create database my_library;
use my_library;

create table category (
	category varchar(50) primary key,
    text_description text,
    quantity_in_lib int not null
);

create table student_card (
	student_number varchar(15) primary key,
    student_name varchar(50) not null,
    address text not null,
    email varchar(50) not null,
    image mediumblob
);

create table book (
	book_number varchar(15) primary key,
    book_name varchar(50) not null,
    publisher varchar(50) not null,
    author varchar(50) not null,
    publish_year int,
    category varchar(50) not null,
    book_vendor varchar(50) not null,
    book_description mediumtext,
    foreign key (category) references category(category)
);

create table borrow_order (
	book_number varchar(15),
    student_number varchar(15),
    borrow_date Date,
    required_date Date,
    returned_date Date default null,
    `status` varchar(15),
    `comment` text,
    primary key (book_number, student_number),    
    foreign key (student_number) references student_card(student_number),
	foreign key (book_number) references book(book_number)
);

insert into category (category, text_description, quantity_in_lib) values
('AA0001', 'romantic book about...', 100),
('AA0002', 'cartoon book about...', 100),
('AA0003', 'action book about...', 100),
('AA0004', 'comedien book about...', 100),
('AA0005', 'science book about...', 100);

select * from category;

insert into student_card (student_number, student_name, address, email, image) values
('201100001', 'Le Toan', '96 Cao Xuan Huy', 'letoandn2193@gmail.com', 1 ),
('201300002', 'Le Hung', '100 Li Thai To', 'lehung3@gmail.com', 2 ),
('201200003', 'Le Vuong', '256 Dien Bien Phu', 'levuonggmail.com', 3 ),
('201500004', 'Le Dat', '04 Le Duan', 'ledat3@gmail.com', 4 ),
('201400005', 'Le Ham', '73 Li Tu Trong', 'leham@gmail.com', 5 ),
('201100006', 'Le Binh', '27 Huynh Ngoc Hue', 'lebinhgmail.com', 6 );

select * from student_card;

insert into book (book_number, book_name, publisher, author, publish_year, category, book_vendor, book_description) values
('TC00001', 'Toi Thay Hoa Vang Tren Co Xanh', 'NXB Kim Dong', 'Nguyen Nhat Anh', 1993, 'AA0001', '...', 'this is a story about...' ),
('TC00002', 'The World is Flat', 'NXB The Gioi Tre', 'Thomas Friedman', 2000, 'AA0005', '...', 'this is a story about...' ),
('TC00003', 'Dac Nhan Tam', 'NXB Simon and Schuster', '‎Dale Carnegie',  1990, 'AA0005', '...', 'this is a story about...' ),
('TC00004', '‎Nha Gia Kim', 'NXB Kim Dong', '‎Paulo Coelho', 1988, 'AA0003', '...', 'this is a story about...' ),
('TC00005', 'Nhung Nguoi Khon Kho', 'NXB A. Lacroix, Verboeckhoveng', '‎Victor Hugo', 1999, 'AA0003', '...', 'this is a story about...' );

select * from book;

insert into borrow_order (book_number, student_number, borrow_date, required_date, returned_date, `status`, `comment`) values
('TC00001', '201300002', '2000-11-10', '2000-11-15', default, 'waiting', 'This is a student...'),
('TC00003', '201300002', '2011-01-15', '2011-01-20', '2011-01-19', 'finish', 'This is a student...'),
('TC00002', '201100006', '2020-07-27', '2020-08-02', '2020-08-03', 'finish', 'This is a student...'),
('TC00001', '201500004', '2019-12-07', '2019-12-13', '2019-12-12', 'finish', 'This is a student...'),
('TC00001', '201200003', '2007-11-10', '2007-11-15', '2007-12-12', 'finish', 'This is a student...');

select * from borrow_order;
