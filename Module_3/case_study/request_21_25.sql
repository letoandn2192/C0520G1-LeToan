use furama_resort;

/*Request 21: Tạo khung nhìn có tên là V_NHANVIEN để lấy được thông tin của tất cả các nhân viên có địa chỉ là “Hải Châu” 
và đã từng lập hợp đồng cho 1 hoặc nhiều Khách hàng bất kỳ  với ngày lập hợp đồng là “12/12/2019”*/
create or replace view V_NHANVIEN as
select employee.*
from employee 
inner join contract on employee_id = contract_employee_id
where employee_address = 'Huế'
	and contract_date_start = '2016-09-10';
 
/*Request 22: Thông qua khung nhìn V_NHANVIEN thực hiện cập nhật địa chỉ thành “Liên Chiểu” đối với tất cả các 
Nhân viên được nhìn thấy bởi khung nhìn này.*/
update V_NHANVIEN
set employee_address = 'Liên Chiểu';

/*Request 23: Tạo Store procedure Sp_1 Dùng để xóa thông tin của một 
Khách hàng nào đó với Id Khách hàng được truyền vào như là 1 tham số của Sp_1*/
delimiter //
create procedure Sp_1 (in id int) 
	begin
		set foreign_key_checks = 0;
        delete from customer
        where customer_id = id;
        set foreign_key_checks = 1;
    end //
delimiter ;

call furama_resort.Sp_1(1);

/*Request 24: Tạp Store procedure Sp_2 Dùng để thêm mới vào bảng HopDong với yêu cầu Sp_2 phải thực hiện
 kiểm tra tính hợp lệ của dữ liệu bổ sung, với nguyên tắc không được trùng khóa chính và đảm bảo toàn vẹn tham chiếu đến các bảng liên quan.*/
delimiter //
create procedure Sp_2 (
    in employee_id int,
    in customer_id int,
    in services_id int,
    in date_start date,
    in date_finish date,
    in deposit_money decimal(10,2),
    in total_money decimal(10,2)
) 
	begin
		if employee_id in (select employee_id from employee) and customer_id in (select customer_id from customer) 
        and services_id in (select services_id from services) then
		insert into contract (contract_employee_id, contract_customer_id, contract_services_id, contract_date_start,
		contract_date_finish, contract_deposit_money, contract_total_money)
        values
        (employee_id, customer_id, services_id, date_start, date_finish, deposit_money, total_money);
        end if;
    end //
delimiter ; 

call Sp_2(10, 10, 1, '2020-08-29', '2020-08-30', 150, 1500);

/*Request 28: Tạo Store procedure Sp_3 để tìm các dịch vụ được thuê bởi khách hàng với loại dịch vụ là 
“Room” từ đầu năm 2015 đến hết năm 2019 để xóa thông tin của các dịch vụ đó (tức là xóa các bảng ghi trong bảng DichVu) 
và xóa những HopDong sử dụng dịch vụ liên quan (tức là phải xóa những bản gi trong bảng HopDong) và những bản liên quan khác.*/
delimiter //
create procedure Sp_3 () 
	begin
		delete from services
        where services_id in (select * from (select services_id
							from services
							inner join contract on services_id = contract_services_id
							where services_type_id = 3 and year(contract_date_start) in (2016, 2017, 2018, 2019)) as temp);
    end //
delimiter ;
drop procedure Sp_3;
call Sp_3();


 