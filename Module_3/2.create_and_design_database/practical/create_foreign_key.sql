DROP DATABASE IF EXISTS my_database;
CREATE DATABASE my_database;
USE my_database;
CREATE TABLE customers(
   id INT PRIMARY KEY,
   name VARCHAR(40),
   address VARCHAR(255),
   email VARCHAR(255)
);

CREATE TABLE orders(
   id INT AUTO_INCREMENT,
   staff VARCHAR(50),
   PRIMARY KEY(id),
   customer_id INT,
   FOREIGN KEY (customer_id) REFERENCES customers(id)
);

ALTER TABLE orders
	DROP FOREIGN KEY orders_ibfk_1;
    
ALTER TABLE customers
	DROP PRIMARY KEY;
