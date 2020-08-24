use furama_resort;
/*Request 16: Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2017 đến năm 2019.*/
SET FOREIGN_KEY_CHECKS=0;
delete from employee
where employee_id not in (select contract_employee_id
						from contract
                        where year(contract_date_start) in (2017, 2018, 2019));
SET FOREIGN_KEY_CHECKS=1;   

-- Using ON DELETE CASCADE
-- delete from employee
-- where employee_id not in (select contract_employee_id
-- 						from contract
--                         where year(contract_date_start) in (2017, 2018, 2019)); 

/*Request 20: Hiển thị thông tin của tất cả các Nhân viên và Khách hàng có trong hệ thống, 
thông tin hiển thị bao gồm ID (IDNhanVien, IDKhachHang), HoTen, Email, SoDienThoai, NgaySinh, DiaChi.*/
select customer_id ID, customer_name `Name`, customer_email Email, 
	customer_phone 'Phone Number', customer_date_of_birth 'Date of Birth', customer_address 'Address'
from customer
union all
select employee_id, employee_name, employee_email, employee_phone, employee_date_of_birth, employee_address
from employee;