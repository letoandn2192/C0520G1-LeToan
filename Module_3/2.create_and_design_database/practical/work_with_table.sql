DROP DATABASE IF EXISTS my_database;
CREATE DATABASE my_database;
USE my_database;
CREATE TABLE my_table(
contact_id INT NOT NULL AUTO_INCREMENT,
last_name VARCHAR(30) NOT NULL,
first_name VARCHAR(25),
birthday DATE,
CONSTRAINT contact_pk PRIMARY KEY (contact_id)
);

INSERT INTO my_table ( last_name, first_name, birthday) VALUES
('Toan', 'Le', '1996-07-01'),
( 'Hung', 'Le', '2000-09-11'),
( 'Tan', 'Le', '1993-07-01'),
( 'Chuong', 'Le', '1990-02-21'),
( 'Quang', 'Le', '1980-11-30'),
( 'Vu', 'Le', '1975-05-12'),
( 'Binh', 'Le', '1999-08-05');

SELECT * FROM my_table;

CREATE TABLE suppliers
( supplier_id INT NOT NULL AUTO_INCREMENT,
  supplier_name VARCHAR(50) NOT NULL,
  account_rep VARCHAR(30) NOT NULL DEFAULT 'TBD',
  CONSTRAINT suppliers_pk PRIMARY KEY (supplier_id)
);

INSERT INTO suppliers ( supplier_name, account_rep) VALUES
('Toan',  'fan'),
( 'Hung', DEFAULT);

ALTER TABLE suppliers
ADD phone INT DEFAULT 10
AFTER supplier_name;

SELECT * FROM suppliers;