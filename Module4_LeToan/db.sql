drop database if exists case_study;
create database case_study;

use case_study;
-- 1. add position
insert into `position` ( position_name)
values
('Receptionist'),
('Serve'),
('Expert'),
('Supervisor'),
('Manager'),
('Director');

-- 2. add education_degree
insert into education_degree (education_degree_name)
values
('Intermediate'),
('Colleges'),
('University'),
('After university');

-- 3. add division
insert into division (division_name)
values
('Sale – Marketing'),
('Administrative'),
('Service'),
('Management');

-- 4. add customer_type
insert into customer_type (customer_type_name)
values
('Diamond'),
('Platinium'),
('Gold'),
('Silver'),
('Member');

-- 5. add rent_type
insert into rent_type (rent_type_name, rent_type_cost)
values
('Year', 12000),
('Month', 1500),
('Day', 70),
('Hour', 5);

-- 6. add service_type
insert into service_type (service_type_name)
values
('Villa'),
('House'),
('Room');

insert into attach_service (attach_service_name, attach_service_cost, attach_service_unit, attach_service_status)
values
('Massage', 100, 20, 'Available'),
('Karaoke', 150, 30, 'Available'),
('Food', 30, 10, 'Available'),
('Drink', 15, 10, 'Available'),
('Car', 200, 15, 'Available');

insert into user (user_name, `password`) 
values 
('username', '123456789');