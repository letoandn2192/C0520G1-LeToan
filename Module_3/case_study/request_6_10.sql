use furama_resort;
/*Request 6: Hiển thị IDDichVu, TenDichVu, DienTich, ChiPhiThue, TenLoaiDichVu của tất cả các loại 
Dịch vụ chưa từng được Khách hàng thực hiện đặt từ quý 1 của năm 2019 (Quý 1 là tháng 1, 2, 3).*/
select services_id, services_name, services_area, services_price,type_services_name, contract_date_start, contract_date_finish
from services
left join contract on contract_services_id = services_id
left join type_of_services on type_services_id = services_type_id
where not (
	(month(contract_date_start) in (1,2,3) and year(contract_date_start) = 2019)
	or (month(contract_date_finish) in (1,2,3) and year(contract_date_finish) = 2019)
    or (year(contract_date_start) < 2019 and year(contract_date_finish) > 2019)
    )
    or contract_date_start is null;
    
/*Request 7: Hiển thị thông tin IDDichVu, TenDichVu, DienTich, SoNguoiToiDa, ChiPhiThue, TenLoaiDichVu 
của tất cả các loại dịch vụ đã từng được Khách hàng đặt phòng trong năm 2018 nhưng chưa từng được Khách 
hàng đặt phòng  trong năm 2019.*/    


/*Request8:	Hiển thị thông tin HoTenKhachHang có trong hệ thống, với yêu cầu HoThenKhachHang không trùng nhau.*/
/* way 1*/ 
select distinct(customer_name)
from customer;

/*Way 2*/
select customer_name
from customer
group by (customer_name);

/*Way 3*/
select table_1.customer_name
from customer table_1
inner join customer table_2
where table_1.customer_id < table_2.customer_id
	and table_1.customer_name = table_2.customer_name;