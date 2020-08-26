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

/* Request 17: Cập nhật thông tin những khách hàng có TenLoaiKhachHang từ  Platinium lên Diamond, 
chỉ cập nhật những khách hàng đã từng đặt phòng với tổng Tiền thanh toán trong năm 2019 là lớn hơn 10.000.000 VNĐ.*/
update customer
set customer_type_id = 1
where customer_id in 
	(select * 
    from ( select customer_id
			from customer 
			inner join contract on contract_customer_id = customer_id
			where year(contract_date_start) = 2019 and customer_type_id = 2
			group by contract_customer_id
			having sum(contract_total_money) > 10000000) temp);
    
/*Request 18: Xóa những khách hàng có hợp đồng trước năm 2016 (chú ý ràngbuộc giữa các bảng).*/    
set foreign_key_checks = 0;	
delete from customer
where customer_id in (select * from
					(select customer_id 
					from customer
					inner join contract on contract_customer_id = customer_id
					where year(contract_date_start) <= 2016 
						and customer_id not in (select contract_customer_id
												from contract
												where year(contract_date_start) > 2016)) temp);
set foreign_key_checks = 1;

/*Request 19: Cập nhật giá cho các Dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2019 lên gấp đôi.*/
update included_services 
set included_services_price = included_services_price * 2
where included_services_id in (select *
								from (select detail_contract_included_services_id
								from detail_contract
								inner join contract on contract.contract_id = detail_contract.contract_id
								where year(contract_date_start) = 2019
								group by detail_contract_included_services_id
								having count(detail_contract_included_services_id) > 0) temp);
                                
/*Request 20: Hiển thị thông tin của tất cả các Nhân viên và Khách hàng có trong hệ thống, 
thông tin hiển thị bao gồm ID (IDNhanVien, IDKhachHang), HoTen, Email, SoDienThoai, NgaySinh, DiaChi.*/
select customer_id ID, customer_name `Name`, customer_email Email, 
	customer_phone 'Phone Number', customer_date_of_birth 'Date of Birth', customer_address 'Address'
from customer
union all
select employee_id, employee_name, employee_email, employee_phone, employee_date_of_birth, employee_address
from employee;