Drop database if exists my_database;
create database my_database;
use my_database;

/*Products Line Entity*/
create table ProductsLine (
	productLineNumber varchar(50) primary key,
    textDesciption text,
    image mediumblob
);

/*Products Entity*/
create table Products (
	productCode varchar(15) primary key,
    productName varchar(70) not null,
    productScale varchar(10) not null,
    productVentor varchar(50) not null,
    productDesciption text not null,
    quantityInStock int not null,
    buyPrice decimal(10,2) not null,
    MSRP decimal(10,2) not null,
    productLineNumber varchar(50),
    foreign key (productLineNumber) references ProductsLine(productLineNumber)
);

/*Offices Entity*/
create table Offices (
	officeCode varchar(10) primary key,
    city varchar(50) not null,
    phone varchar(50) not null,
    addressLine1 varchar(50) not null,
    addressLine2 varchar(50),
    state varchar(50),
    country varchar(50),
    postalCode varchar(10) not null
);

/*Employees Entity*/
create table Employees (
	employeeNumber int primary key,
    lastName varchar(50) not null,
    firstName varchar(50) not null,
    email varchar(100) not null,
    jobTitle varchar(50) not null,
    officeCode varchar(10),
    reportTo int,
    foreign key (reportTo) references Employees(employeeNumber),
    foreign key (officeCode) references Offices(officeCode)
);

/*Customer Entity*/
create table Customers (
	customerNumber int primary key,
    customerName varchar(50) not null,
    contactLastName varchar(50) not null,
    contactFirstName varchar(50) not null,
    phone varchar(50) not null,
    addressLine1 varchar(50) not null,
    addressLine2 varchar(50),
    city varchar(50) not null,
    state varchar(50) not null,
    postalCode varchar(15) not null,
    country varchar(50) not null,
    creditLimit decimal(10,2) not null,
    salesRepEmployeeNumber int,
    foreign key (salesRepEmployeeNumber) references Employees(employeeNumber)
);

/*Orders Entity*/
create table Orders (
	orderNumber int primary key,
    orderDate Date not null,
    requiredDate Date not null,
    shippedDate Date not null,
    `status` varchar(15) not null,
    comments text,
    customerNumber int,
    foreign key (customerNumber) references Customers(customerNumber)
);

/*OrderDetails Entity*/
create table OrderDetail (
	productCode varchar(50),
    orderNumber int,
	quantityOrdered int not null,
    priceEach decimal(10,2) not null,
    foreign key (productCode) references Products(productCode),
    foreign key (orderNumber) references Orders(orderNumber)
);

/*Payments Entity*/
create table Payments (
	customerNumber int primary key,
    checkNumber varchar(50) not null,
    paymentDate Date not null,
    amount decimal(10,2) not null,
    foreign key (customerNumber) references Customers(customerNumber)
);