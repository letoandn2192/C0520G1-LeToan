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
select services_id, services_name, services_area, servicers_max_person, services_price, type_services_name
from services
inner join contract on contract_services_id = services_id
inner join type_of_services on type_services_id = services_type_id
where year(contract_date_start) = 2018 
		and services_id not in (select services_id
								from services
								where year(contract_date_start) = 2019);

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
    
/*Request 9: 9.	Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi tháng trong năm 2019 
thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.*/    
select monthname(contract_date_start) as `Month`, count(contract_id) as 'Number of Customer',  sum(contract_total_money) Total
from contract
where year(contract_date_start) = 2019
group by month(contract_date_start);
    
/*Request 10: Hiển thị thông tin tương ứng với từng Hợp đồng thì đã sử dụng bao nhiêu Dịch vụ đi kèm. 
Kết quả hiển thị bao gồm IDHopDong, NgayLamHopDong, NgayKetthuc, TienDatCoc, SoLuongDichVuDiKem 
(được tính dựa trên việc count các IDHopDongChiTiet).*/    
select contract.contract_id, contract_date_start, contract_date_finish, contract_deposit_money, count(detail_contract_id) as Amount
from contract
inner join detail_contract on contract.contract_id = detail_contract.contract_id
inner join included_services on included_services_id = detail_contract_included_services_id
group by contract.contract_id;



