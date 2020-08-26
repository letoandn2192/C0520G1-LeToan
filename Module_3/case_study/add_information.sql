/*REQUEST1: ADD DATA INTO TABLES*/

use furama_resort;
-- 1. add position
insert into `position` ( position_name)
values
('Receptionist'),
('Serve'),
('Expert'),
('Supervisor'),
('Manager'),
('Director');

-- 2. add level
insert into `level` (level_name)
values
('Intermediate'),
('Colleges'),
('University '),
('After university');

-- 3. department
insert into department (department_name)
values
('Sale – Marketing'),
('Administrative'),
('Service'),
('Management');

-- 4. customer_type
insert into type_of_customer (type_customer_name)
values
('Diamond'),
('Platinium'),
('Gold'),
('Silver'),
('Member');

-- 5. rent_type
insert into type_of_rent (type_rent_name, type_rent_price)
values
('Year', 12000),
('Month', 1500),
('Day', 70),
('Hour', 5);

-- 6. service_type
insert into type_of_services (type_services_name)
values
('Villa'),
('House'),
('Room');

-- 7. included_services
insert into included_services (included_services_name, included_services_price, included_services_unit, included_services_status)
values
('Massage', 100, 20, 'Available'),
('Karaoke', 150, 30, 'Available'),
('Food', 30, 10, 'Available'),
('Drink', 15, 10, 'Available'),
('Car', 200, 15, 'Available');

-- 8. employee
insert into employee (employee_name, employee_position_id, employee_level_id, employee_department_id, employee_date_of_birth,
employee_id_number, employee_salary, employee_phone, employee_email, employee_address)
values
('Hoàng Thanh Xuân', 1, 2, 3, '2000-10-08', '201756803', 600, '0902872813', 'thanhxuanhoang@gmail.com', 'Quảng Ngãi'),
('Thái Thị Thanh', 2, 1, 3, '1996-05-18', '201652386', 500, '0332829745', 'thanhthaithi@gmail.com', 'Quảng Trị'),
('Kim Trọng', 4, 3, 4, '1993-02-01', '207953408', 1500, '0902867439', 'kimtrong123@gmail.com', 'Đà Nẵng'),
('Hồ Thanh Nga', 3, 3, 4, '1995-07-23', '200879648', 1400, '0935043348', 'ngahothanh@gmail.com', 'Quảng Nam'),
('Dương Quảng Hàm', 6, 4, 4, '1990-11-25', '200479634', 3000, '0935749682', 'hamduongquang@gmail.com', 'Đà Nẵng'),
('Phan Đăng Lưu', 2, 2, 3, '1999-09-12', '207596304', 550, '0935762837', 'dangluuphan@gmail.com', 'Huế'),
('Nguyễn Hữu Thọ', 3, 3, 1, '1997-12-12', '201196758', 1100, '0905839513', 'thonguyenhuu@gmail.com', 'Bình Định'),
('Đinh Tiến Đạt', 4, 3, 2, '1994-01-30', '200975803', 900, '0906877619', 'datdinh@gmail.com', 'Khánh Hòa'),
('Dương Triệu Vũ', 5, 4, 1, '1993-10-17', '2010564283', 2000, '0902872813', 'tonyvu@gmail.com', 'Đà Nẵng'),
('Chu Mạnh Trinh', 2, 2, 3, '1995-02-02', '201256795', 650, '0909438815', 'chumanhtrinh@gmail.com', 'Quảng Ngãi');

-- 9. customer
insert into customer (customer_type_id, customer_name, customer_date_of_birth, customer_id_number, customer_phone,
customer_email, customer_address)
values
(1, 'Nguyến Hương Giang', '1993-02-01', '201935404', '09028783813', 'giangnguyenhuong@gmail.com', 'Quảng Ngãi'),
(2, 'Trương Tấn Sang', '1989-08-21', '200935491', '09058779513', 'sangtruongtan@gmail.com', 'Hải Phòng'),
(3, 'Trương Công An', '1985-11-27', '200835762', '09054337453', 'truongcongan@gmail.com', 'Hồ Chí Minh'),
(4, 'Lương Xuân Trường', '1995-10-19', '201361834', '0933783517', 'luongxuantruong@gmail.com', 'Tuyên Quang'),
(5, 'Huỳnh Tuấn Anh', '1990-02-01', '201046624', '0935456728', 'tuananhhuynh@gmail.com', 'Quảng Trị'),
(1, 'Trương Quỳnh Anh', '1991-11-08', '201064825', '0332846712', 'congchuabongbong@gmail.com', 'Cần Thơ'),
(2, 'Lương Bằng Quang', '1989-06-11', '200945628', '0977462836', 'quangluong@gmail.com', 'Đồng Tháp'),
(3, 'Khổng Tú Quỳnh', '1994-12-07', '201408635', '0944168359', 'quynhngaytho@gmail.com', 'Sơn La'),
(4, 'Đàm Vĩnh Hưng', '1988-04-01', '200845679', '0936482178', 'hungdam@gmail.com', 'Bến Tre'),
(5, 'Trần Quang Cường', '1995-03-31', '201345682', '0988123852', 'cuongtranquang@gmail.com', 'Cà Mau'),
(1, 'Lê Toàn', '1993-01-02', '201635805', '0902872813', 'letoandn2193@gmail.com', 'Vinh');

-- 10. services
insert into services (services_name, services_area, services_floor, servicers_max_person, services_price,
services_type_rent_id, services_type_id, services_status)
values
('Villa Beautiful', 100, 3, 20, 1000, 3, 1, 'Available'),
('Villa Vip', 150, 2, 15, 2000, 2, 1, 'Available'),
('Villa Mascarano', 200, 4, 20, 3500, 1, 1, 'Available'),
('House Pretty', 100, 3, 10, 600, 2, 2, 'Available'),
('House Small', 120, 4, 15, 800, 3, 2, 'Available'),
('House Little', 150, 2, 8, 400, 4, 2, 'Available'),
('Room HaHa', 75, null, 4, 120, 4, 3, 'Available'),
('Room Grave', 100, null, 6, 1000, 2, 3, 'Available'),
('Room Vintage', 90, null, 5, 20, 3, 3, 'Available');

-- 11. contract
insert into contract (contract_employee_id, contract_customer_id, contract_services_id, contract_date_start,
contract_date_finish, contract_deposit_money, contract_total_money)
values
(1, 1, 1, '2019-10-10', '2019-11-10', 100, 1000),
(2, 3, 8, '2018-01-10', '2018-01-15', 70, 400),
(3, 7, 3, '2017-05-05', '2017-05-06', 10, 100),
(4, 9, 4, '2019-10-10', '2020-10-10', 1000, 3000),
(5, 6, 7, '2019-03-10', '2019-12-10', 1000, 2500),
(6, 2, 2, '2016-09-10', '2020-03-10', 2000, 10000),
(7, 1, 5, '2018-07-30', '2018-07-30', 10, 20),
(8, 10, 5, '2016-04-30', '2016-05-30', 100, 800),
(8, 7, 5, '2019-04-30', '2019-05-30', 100, 1000),
(5, 7, 1, '2019-07-30', '2019-09-30', 100, 2000);

-- 12. detail_contract
insert into detail_contract (contract_id, detail_contract_included_services_id, detail_contract_amount)
values
(1, 2, 1),
(2, 1, 2),
(3, 2, 5),
(4, 3, 4),
(5, 4, 3),
(6, 3, 5),
(7, 5, 1),
(1, 1, 2);

-- select * from contract;
-- select * from customer;
-- select * from department;
-- select * from detail_contract;
-- select * from employee;
-- select * from included_services;
-- select * from `level`;
-- select * from `position`;
-- select * from services;
-- select * from type_of_customer;
-- select * from type_of_rent;
-- select * from type_of_services;
