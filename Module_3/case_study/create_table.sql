drop database if exists furama_resort;
create database furama_resort;
use furama_resort;

-- 1.create table position
create table `position` (
	position_id int auto_increment primary key,
    position_name varchar(45) not null
);

-- 2.create table level
create table `level` (
	level_id int auto_increment primary key ,
    level_name varchar(45) not null
);

-- 3.create table department
create table department (
	department_id int auto_increment primary key,
    department_name varchar(45) not null
);

-- 4.create table customer_type
create table type_of_customer (
	type_customer_id int auto_increment primary key,
    type_customer_name varchar(45)
);

-- 5.create table rent_type
create table type_of_rent (
	type_rent_id int auto_increment primary key,
    type_rent_name varchar(45) not null,
    type_rent_price decimal(10,2) not null
);

-- 6.create table service_type
create table type_of_services (
	type_services_id int auto_increment primary key,
    type_services_name varchar(45) not null
);

-- 7.create table included_services
create table included_services (
	included_services_id int auto_increment primary key,
    included_services_name varchar(45),
    included_services_price decimal(10,2),
    included_services_unit int,
    included_services_status varchar(45)
);	

-- 8.create table employee
create table employee (
	employee_id int auto_increment primary key,
    employee_name varchar(45) not null,
    employee_position_id int,
    employee_level_id int,
    employee_department_id int,
    employee_date_of_birth date not null,
    employee_id_number varchar(45) not null,
    employee_salary varchar(45) not null,
    employee_phone varchar(45) not null,
    employee_email varchar(45) not null,
    employee_address varchar(45) not null,
    foreign key (employee_position_id) references `position`(position_id),
    foreign key (employee_level_id) references `level`(level_id),
    foreign key (employee_department_id) references department(department_id)
);

-- 9.create table customer
create table customer (
	customer_id int auto_increment primary key,
    customer_type_id int,
    customer_name varchar(45) not null,
    customer_date_of_birth varchar(45) not null,
    customer_id_number varchar(45) not null,
    customer_phone varchar(45) not null,
    customer_email varchar(45) not null,
    customer_address varchar(45) not null,
    foreign key (customer_type_id) references type_of_customer(type_customer_id) 
);

-- 10.create table services
create table services (
	services_id int auto_increment primary key,
    services_name varchar(45) not null,
    services_area decimal(10,2) not null,
    services_floor int,
    servicers_max_person int not null,
    services_price decimal(10,2) not null,
    services_type_rent_id int,
    services_type_id int,
    services_status varchar(45) not null,
    foreign key (services_type_rent_id) references type_of_rent(type_rent_id),
    foreign key (services_type_id) references type_of_services(type_services_id)
);

-- 11.create table contract
create table contract (
	contract_id int auto_increment primary key,
    contract_employee_id int,
    contract_customer_id int,
    contract_services_id int,
    contract_date_start date not null,
    contract_date_finish date not null,
    contract_deposit_money decimal(10,2) not null,
    contract_total_money decimal(10,2) not null,
    foreign key (contract_employee_id) references employee(employee_id) on delete cascade,
    foreign key (contract_customer_id) references customer(customer_id) on delete cascade,
    foreign key (contract_services_id) references services(services_id)
);

-- 12.create table	detail_contract
create table detail_contract (
	detail_contract_id int auto_increment primary key,
    contract_id int,
    detail_contract_included_services_id int,
    detail_contract_amount int not null,
    foreign key (contract_id) references contract(contract_id) on delete cascade,
    foreign key (detail_contract_included_services_id) references included_services(included_services_id)
);