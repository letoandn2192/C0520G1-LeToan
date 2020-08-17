Drop database if exists my_database;
create database my_database;
use my_database;

/*Products Line Entity*/
create table products_line (
	product_line_number varchar(50) primary key,
    text_desciption text,
    image mediumblob
);

/*Products Entity*/
create table products (
	product_code varchar(15) primary key,
    product_name varchar(70) not null,
    product_scale varchar(10) not null,
    product_ventor varchar(50) not null,
    product_desciption text not null,
    quantity_in_stock int not null,
    buy_price decimal(10,2) not null,
    MSRP decimal(10,2) not null,
    product_line_number varchar(50),
    foreign key (product_line_number) references products_line(product_line_number)
);

/*Offices Entity*/
create table offices (
	office_code varchar(10) primary key,
    city varchar(50) not null,
    phone varchar(50) not null,
    address_line1 varchar(50) not null,
    address_line2 varchar(50),
    state varchar(50),
    country varchar(50),
    postal_code varchar(10) not null
);

/*Employees Entity*/
create table employees (
	employee_number int primary key,
    last_name varchar(50) not null,
    first_name varchar(50) not null,
    email varchar(100) not null,
    job_title varchar(50) not null,
    office_code varchar(10),
    report_to int,
    foreign key (report_to) references employees(employee_number),
    foreign key (office_code) references offices(office_code)
);

/*Customer Entity*/
create table customers (
	customer_number int primary key,
    customer_name varchar(50) not null,
    contact_last_name varchar(50) not null,
    contact_first_name varchar(50) not null,
    phone varchar(50) not null,
    address_line1 varchar(50) not null,
    address_line2 varchar(50),
    city varchar(50) not null,
    state varchar(50) not null,
    postal_code varchar(15) not null,
    country varchar(50) not null,
    credit_limit decimal(10,2) not null,
    sales_rep_employee_number int,
    foreign key (sales_rep_employee_number) references employees(employee_number)
);

/*Orders Entity*/
create table orders (
	order_number int primary key,
    order_date Date not null,
    required_date Date not null,
    shipped_date Date not null,
    `status` varchar(15) not null,
    comments text,
    customer_number int,
    foreign key (customer_number) references customers(customer_number)
);

/*OrderDetails Entity*/
create table order_detail (
	product_code varchar(50),
    order_number int,
	quantity_ordered int not null,
    price_each decimal(10,2) not null,
    foreign key (product_code) references products(product_code),
    foreign key (order_number) references orders(order_number)
);

/*Payments Entity*/
create table payments (
	customer_number int primary key,
    check_number varchar(50) not null,
    payment_date Date not null,
    amount decimal(10,2) not null,
    foreign key (customer_number) references customers(customer_number)
);