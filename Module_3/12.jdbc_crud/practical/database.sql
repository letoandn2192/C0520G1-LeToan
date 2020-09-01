drop database if exists user_manager;
create database user_manager;
use user_manager;

create table users (
	id int(3) auto_increment primary key,
    `name` varchar(50) not null,
    email varchar(50) not null,
    address varchar(50) not null
);

create table permission (
	id int(3) primary key,
    `name` varchar(50)
);

create table user_permission (
	user_id int(3),
    permission_id int(3),
    foreign key (user_id) references users(id) on delete cascade on update cascade,
    foreign key (permission_id) references permission(id) on delete cascade on update cascade
);

insert into permission (id,`name`)
values
(1,'add'),
(2,'edit'),
(3,'delete'),
(4,'view');

insert into users (`name`, email, address)
values
('Kim Trong', 'trongloichoi@gmail.com', 'Cao Bang'),
('Cao Truong Cung', 'cungdau@gmail.com', 'Kien Giang'),
('Truong Thuy Kieu', 'kieudj@gmail.com', 'Can Tho'),
('An To To', 'minhgiaohoi@gmail.com', 'Quang Nam'),
('Ly Quang', 'quangtuongquan@gmail.com', 'Bac Ninh');

delimiter //
create procedure get_user_by_id (in `index` int)
begin
	select *
    from users
    where id = `index`;
end //
delimiter ;

delimiter //
create procedure insert_user (
	in `Name` varchar(50),
    in Email varchar(50),
    in Address varchar(50) )
begin
	insert into users (`name`, email, address)
    values
    (`Name`, Email, Address);
end //
delimiter ; 