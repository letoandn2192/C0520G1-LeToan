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

-- 2. add education_degree
insert into education_degree (education_degree_name)
values
('Intermediate'),
('Colleges'),
('University '),
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

-- 7. add attach_service
insert into attach_service (attach_service_name, attach_service_cost, attach_service_unit, attach_service_status)
values
('Massage', 100, 20, 'Available'),
('Karaoke', 150, 30, 'Available'),
('Food', 30, 10, 'Available'),
('Drink', 15, 10, 'Available'),
('Car', 200, 15, 'Available');

-- 8. add employee
insert into employee (employee_name, employee_birthday,
employee_id_card, employee_salary, employee_phone, employee_email, employee_address, position_id, education_degree_id, division_id, username)
values
('Hoàng Thanh Xuân', '2000-10-08', '201756803', 600, '0902872813', 'thanhxuanhoang@gmail.com', 'Quảng Ngãi', 1, 2, 3, null),
('Thái Thị Thanh', '1996-05-18', '201652386', 500, '0332829745', 'thanhthaithi@gmail.com', 'Quảng Trị', 2, 1, 3, null),
('Kim Trọng', '1993-02-01', '207953408', 1500, '0902867439', 'kimtrong123@gmail.com', 'Đà Nẵng', 4, 3, 4, null),
('Hồ Thanh Nga', '1995-07-23', '200879648', 1400, '0935043348', 'ngahothanh@gmail.com', 'Quảng Nam', 3, 3, 4, null),
('Dương Quảng Hàm', '1990-11-25', '200479634', 3000, '0935749682', 'hamduongquang@gmail.com', 'Đà Nẵng', 6, 4, 4, null),
('Phan Đăng Lưu', '1999-09-12', '207596304', 550, '0935762837', 'dangluuphan@gmail.com', 'Huế', 2, 2, 3, null),
('Nguyễn Hữu Thọ', '1997-12-12', '201196758', 1100, '0905839513', 'thonguyenhuu@gmail.com', 'Bình Định', 3, 3, 1, null),
('Đinh Tiến Đạt', '1994-01-30', '200975803', 900, '0906877619', 'datdinh@gmail.com', 'Khánh Hòa', 4, 3, 2, null),
('Dương Triệu Vũ', '1993-10-17', '2010564283', 2000, '0902872813', 'tonyvu@gmail.com', 'Đà Nẵng', 5, 4, 1, null),
('Chu Mạnh Trinh', '1995-02-02', '201256795', 650, '0909438815', 'chumanhtrinh@gmail.com', 'Quảng Ngãi', 2, 2, 3, null);

-- 9. add customer
insert into customer (customer_type_id, customer_name, customer_birthday, customer_gender, customer_id_card, customer_phone,
customer_email, customer_address)
values
(1, 'Nguyến Hương Giang', '1993-02-01', 'female', '201935404', '09028783813', 'giangnguyenhuong@gmail.com', 'Quảng Ngãi'),
(2, 'Trương Tấn Sang', '1989-08-21', 'male', '200935491', '09058779513', 'sangtruongtan@gmail.com', 'Hải Phòng'),
(3, 'Trương Công An', '1985-11-27', 'male', '200835762', '09054337453', 'truongcongan@gmail.com', 'Hồ Chí Minh'),
(4, 'Lương Xuân Trường', '1995-10-19', 'male', '201361834', '0933783517', 'luongxuantruong@gmail.com', 'Tuyên Quang'),
(5, 'Huỳnh Tuấn Anh', '1990-02-01', 'male', '201046624', '0935456728', 'tuananhhuynh@gmail.com', 'Quảng Trị'),
(1, 'Trương Quỳnh Anh', '1991-11-08', 'female', '201064825', '0332846712', 'congchuabongbong@gmail.com', 'Cần Thơ'),
(2, 'Lương Bằng Quang', '1989-06-11', 'male', '200945628', '0977462836', 'quangluong@gmail.com', 'Đồng Tháp'),
(3, 'Khổng Tú Quỳnh', '1994-12-07', 'female', '201408635', '0944168359', 'quynhngaytho@gmail.com', 'Sơn La'),
(4, 'Đàm Vĩnh Hưng', '1988-04-01', 'male', '200845679', '0936482178', 'hungdam@gmail.com', 'Bến Tre'),
(5, 'Trần Quang Cường', '1995-03-31', 'male', '201345682', '0988123852', 'cuongtranquang@gmail.com', 'Cà Mau'),
(1, 'Lê Toàn', '1993-01-02', 'male', '201635805', '0902872813', 'letoandn2193@gmail.com', 'Vinh');

-- 10. add service
insert into service (service_name, service_area, service_cost, service_max_person,
rent_type_id, service_type_id, standard_room, description_other_convenience, pool_area, number_of_floors)
values
('Villa Beautiful', 100, 1000, 20, 2, 1, 'Vip', 'No comment', 40, 3),
('House Beautiful', 100, 700, 15, 3, 2, 'Vip', 'No comment', 30, 2);

-- 11. contract
insert into contract (contract_start_date,
contract_end_date, contract_deposit, contract_total_money, employee_id, customer_id, service_id)
values
( '2019-10-10', '2019-11-10', 100, 1000, 1, 1, 1),
( '2018-01-10', '2018-01-15', 70, 400, 2, 3, 1),
( '2017-05-05', '2017-05-06', 10, 100, 3, 7, 2),
( '2019-10-10', '2020-10-10', 1000, 3000, 4, 9, 2),
( '2019-03-10', '2019-12-10', 1000, 2500, 5, 6, 2),
( '2016-09-10', '2020-03-10', 2000, 10000, 6, 2, 2),
( '2018-07-30', '2018-07-30', 10, 20, 7, 1, 1),
( '2016-04-30', '2016-05-30', 100, 800, 8, 10, 1),
( '2019-04-30', '2019-05-30', 100, 1000, 8, 7, 2),
( '2019-07-30', '2019-09-30', 100, 2000, 5, 7, 1);

-- 12. add contract_detail
insert into contract_detail (contract_id, attach_service_id, quantity)
values
(1, 2, 1),
(2, 1, 2),
(3, 2, 5),
(4, 3, 4),
(5, 4, 3),
(6, 3, 5),
(7, 5, 1),
(1, 1, 2);