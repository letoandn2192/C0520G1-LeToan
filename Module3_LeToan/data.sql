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

-- 7. add attach_service
insert into attach_service (attach_service_name, attach_service_cost, attach_service_unit, attach_service_status)
values
('Massage', 100, 20, 'Available'),
('Karaoke', 150, 30, 'Available'),
('Food', 30, 10, 'Available'),
('Drink', 15, 10, 'Available'),
('Car', 200, 15, 'Available');

-- 8. add employee
insert into employee (employee_id, employee_name, employee_birthday,
employee_id_card, employee_salary, employee_phone, employee_email, employee_address, position_id, education_degree_id, division_id, username)
values
('NV-0001', 'Hoàng Thanh Xuân', '2000-10-08', '201756803', 600, '0902872813', 'thanhxuanhoang@gmail.com', 'Quảng Ngãi', 1, 2, 3, null),
('NV-0002', 'Thái Thị Thanh', '1996-05-18', '201652386', 500, '0332829745', 'thanhthaithi@gmail.com', 'Quảng Trị', 2, 1, 3, null),
('NV-0003', 'Kim Trọng', '1993-02-01', '207953408', 1500, '0902867439', 'kimtrong123@gmail.com', 'Đà Nẵng', 4, 3, 4, null),
('NV-0004', 'Hồ Thanh Nga', '1995-07-23', '200879648', 1400, '0935043348', 'ngahothanh@gmail.com', 'Quảng Nam', 3, 3, 4, null),
('NV-0005', 'Dương Quảng Hàm', '1990-11-25', '200479634', 3000, '0935749682', 'hamduongquang@gmail.com', 'Đà Nẵng', 6, 4, 4, null),
('NV-0006', 'Phan Đăng Lưu', '1999-09-12', '207596304', 550, '0935762837', 'dangluuphan@gmail.com', 'Huế', 2, 2, 3, null),
('NV-0007', 'Nguyễn Hữu Thọ', '1997-12-12', '201196758', 1100, '0905839513', 'thonguyenhuu@gmail.com', 'Bình Định', 3, 3, 1, null),
('NV-0008', 'Đinh Tiến Đạt', '1994-01-30', '200975803', 900, '0906877619', 'datdinh@gmail.com', 'Khánh Hòa', 4, 3, 2, null),
('NV-0009', 'Dương Triệu Vũ', '1993-10-17', '2010564283', 2000, '0902872813', 'tonyvu@gmail.com', 'Đà Nẵng', 5, 4, 1, null),
('NV-0010', 'Chu Mạnh Trinh', '1995-02-02', '201256795', 650, '0909438815', 'chumanhtrinh@gmail.com', 'Quảng Ngãi', 2, 2, 3, null);

-- 9. add customer
insert into customer (customer_id, customer_type_id, customer_name, customer_birthday, customer_gender, customer_id_card, customer_phone,
customer_email, customer_address)
values
('KH-0001', 1, 'Nguyến Hương Giang', '1993-02-01', 0, '201935404', '09028783813', 'giangnguyenhuong@gmail.com', 'Quảng Ngãi'),
('KH-0002', 2, 'Trương Tấn Sang', '1989-08-21', 1, '200935491', '09058779513', 'sangtruongtan@gmail.com', 'Hải Phòng'),
('KH-0003', 3, 'Trương Công An', '1985-11-27', 1, '200835762', '09054337453', 'truongcongan@gmail.com', 'Hồ Chí Minh'),
('KH-0004', 4, 'Lương Xuân Trường', '1995-10-19', 1, '201361834', '0933783517', 'luongxuantruong@gmail.com', 'Tuyên Quang'),
('KH-0005', 5, 'Huỳnh Tuấn Anh', '1990-02-01', 1, '201046624', '0935456728', 'tuananhhuynh@gmail.com', 'Quảng Trị'),
('KH-0006', 1, 'Trương Quỳnh Anh', '1991-11-08', 0, '201064825', '0332846712', 'congchuabongbong@gmail.com', 'Cần Thơ'),
('KH-0007', 2, 'Lương Bằng Quang', '1989-06-11', 1, '200945628', '0977462836', 'quangluong@gmail.com', 'Đồng Tháp'),
('KH-0008', 3, 'Khổng Tú Quỳnh', '1994-12-07', 0, '201408635', '0944168359', 'quynhngaytho@gmail.com', 'Sơn La'),
('KH-0009', 4, 'Đàm Vĩnh Hưng', '1988-04-01', 1, '200845679', '0936482178', 'hungdam@gmail.com', 'Bến Tre'),
('KH-0010', 5, 'Trần Quang Cường', '1995-03-31', 1, '201345682', '0988123852', 'cuongtranquang@gmail.com', 'Cà Mau'),
('KH-0011', 1, 'Lê Toàn', '1993-01-02', 1, '201635805', '0902872813', 'letoandn2193@gmail.com', 'Vinh');

-- 10. add service
insert into service (service_id, service_name, service_area, service_cost, service_max_person,
rent_type_id, service_type_id, standard_room, description_other_convenience, pool_area, number_of_floors)
values
('DV-0001', 'Villa Beautiful', 100, 1000, 20, 2, 1, 'Vip', 'No comment', 40, 3),
('DV-0002', 'House Beautiful', 100, 700, 15, 3, 2, 'Vip', 'No comment', 30, 2);

-- 11. contract
insert into contract (contract_start_date,
contract_end_date, contract_deposit, contract_total_money, employee_id, customer_id, service_id)
values
( '2019-10-10', '2019-11-10', 100, 1000, 'NV-0001', 'KH-0001', 'DV-0001'),
( '2018-01-10', '2018-01-15', 70, 400, 'NV-0002', 'KH-0003', 'DV-0001'),
( '2017-05-05', '2017-05-06', 10, 100, 'NV-0003', 'KH-0007', 'DV-0002'),
( '2019-10-10', '2020-10-10', 1000, 3000, 'NV-0004', 'KH-0009', 'DV-0002'),
( '2019-03-10', '2019-12-10', 1000, 2500, 'NV-0005', 'KH-0006', 'DV-0002'),
( '2016-09-10', '2020-03-10', 2000, 10000, 'NV-0006', 'KH-0002', 'DV-0002'),
( '2018-07-30', '2018-07-30', 10, 20, 'NV-0007', 'KH-0001', 'DV-0001'),
( '2016-04-30', '2016-05-30', 100, 800, 'NV-0008', 'KH-0010', 'DV-0001'),
( '2019-04-30', '2019-05-30', 100, 1000, 'NV-0008', 'KH-0007', 'DV-0002'),
( '2019-07-30', '2019-09-30', 100, 2000, 'NV-0005', 'KH-0007', 'DV-0001');

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