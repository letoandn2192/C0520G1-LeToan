drop database if exists furama_resort;
create database furama_resort;
use furama_resort;

-- 1.create table position
create table `position` (
	position_id int auto_increment primary key,
    position_name varchar(45) not null
);

-- 2.create table education_degree
create table education_degree (
	education_degree_id int auto_increment primary key ,
    education_degree_name varchar(45) not null
);

-- 3.create table division
create table division (
	division_id int auto_increment primary key,
    division_name varchar(45) not null
);

-- 4.create table customer_type
create table customer_type (
	customer_type_id int auto_increment primary key,
    customer_type_name varchar(45) not null
);

-- 5.create table rent_type
create table rent_type (
	rent_type_id int auto_increment primary key,
    rent_type_name varchar(45) not null,
    rent_type_cost double not null
);

-- 6.create table service_type
create table service_type (
	service_type_id int auto_increment primary key,
    service_type_name varchar(45) not null
);

-- 7.create table attach_service
create table attach_service (
	attach_service_id int auto_increment primary key,
    attach_service_name varchar(45) not null,
    attach_service_cost double not null,
    attach_service_unit int not null,
    attach_service_status varchar(45) not null
);

-- 8.create table user
create table `user` (
	username varchar(255) primary key,
    `password` varchar(255)
);	

-- 9.create table employee
create table employee (
	employee_id varchar(45) primary key,
    employee_name varchar(45) not null,
    employee_birthday date not null,
    employee_id_card varchar(45) not null,
    employee_salary double not null,
    employee_phone varchar(45) not null,
    employee_email varchar(45) not null,
    employee_address varchar(45) not null,
	position_id int,
    education_degree_id int,
    division_id int,
	username varchar(255),
    foreign key (position_id) references `position`(position_id) on update cascade on delete cascade,
    foreign key (education_degree_id) references education_degree(education_degree_id) on update cascade on delete cascade,
    foreign key (division_id) references division(division_id) on update cascade on delete cascade,
	foreign key (username) references `user`(username) on update cascade on delete cascade
);

-- 10.create table customer
create table customer (
	customer_id varchar(45) primary key,
    customer_type_id int,
    customer_name varchar(45) not null,
    customer_birthday date not null,
    customer_gender bit not null,
    customer_id_card varchar(45) not null,
    customer_phone varchar(45) not null,
    customer_email varchar(45) not null,
    customer_address varchar(45) not null,
    foreign key (customer_type_id) references customer_type(customer_type_id) on update cascade on delete cascade
);

-- 11.create table service
create table service (
	service_id varchar(45) primary key,
    service_name varchar(45) not null,
    service_area double not null,
    service_cost double not null,
    service_max_person int not null,
    rent_type_id int,
    service_type_id int,
    standard_room varchar(45),
    description_other_convenience varchar(45),
    pool_area double,
    number_of_floors int,
    foreign key (rent_type_id) references rent_type(rent_type_id) on update cascade on delete cascade,
    foreign key (service_type_id) references service_type(service_type_id) on update cascade on delete cascade
);

-- 12.create table contract
create table contract (
	contract_id int auto_increment primary key,
	contract_start_date date not null,
    contract_end_date date not null,
	contract_deposit double not null,
    contract_total_money double not null,
    employee_id varchar(45),
    customer_id varchar(45),
    service_id varchar(45),
    foreign key (employee_id) references employee(employee_id)  on update cascade on delete cascade,
    foreign key (customer_id) references customer(customer_id)  on update cascade on delete cascade,
    foreign key (service_id) references service(service_id)  on update cascade on delete cascade
);

-- 13.create table	contract_detail
create table contract_detail (
	contract_detail_id int auto_increment primary key,
    contract_id int,
    attach_service_id int,
    quantity int not null,
    foreign key (contract_id) references contract(contract_id) on update cascade on delete cascade,
    foreign key (attach_service_id) references attach_service(attach_service_id) on update cascade on delete cascade
);

-- 14.create table role
create table `role` (
	role_id int auto_increment primary key,
    role_name varchar(255)
);


-- 15.create table user_role
create table user_role (
	role_id int ,
    username varchar(255),
    foreign key (role_id) references `role`(role_id) on update cascade on delete cascade,
    foreign key (username) references `user`(username) on update cascade on delete cascade
);