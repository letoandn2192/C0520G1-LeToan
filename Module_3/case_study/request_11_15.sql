use furama_resort;

/*Request 11: Hiển thị thông tin các Dịch vụ đi kèm đã được sử dụng bởi những Khách hàng có 
TenLoaiKhachHang là “Diamond” và có địa chỉ là “Vinh” hoặc “Quảng Ngãi”.*/
select customer_id, customer_name, customer_address, contract.contract_id, included_services.*
from customer
inner join contract on contract_customer_id = customer_id
inner join detail_contract on contract.contract_id = detail_contract.contract_id
inner join included_services on included_services_id = detail_contract_included_services_id
where customer_type_id = 1
	and customer_address in ('Vinh', 'Quảng Ngãi');
    
 /*Request 12:12.	Hiển thị thông tin IDHopDong, TenNhanVien, TenKhachHang, SoDienThoaiKhachHang, TenDichVu, 
 SoLuongDichVuDikem (được tính dựa trên tổng Hợp đồng chi tiết), TienDatCoc của tất cả các dịch vụ đã từng được 
 khách hàng đặt vào 3 tháng cuối năm 2019 nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2019.*/   
 select contract.contract_id, employee_name, customer_phone, services_name, detail_contract_amount, contract_deposit_money
from services
inner join contract on contract_services_id = services_id
inner join detail_contract on contract_services_id = services_id
inner join type_of_services on type_services_id = services_type_id
inner join employee on employee_id = contract_employee_id
inner join customer on customer_id = contract_customer_id
where year(contract_date_start) = 2019 and quarter(contract_date_start) = 1
		and services_id not in (select services_id
								from services
								where quarter(contract_date_start) in (1,2));   
    
/*Request 13: Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng. 
(Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).*/    
create or replace view hello as
select included_services_id, included_services_name, count(detail_contract_included_services_id) Amount
from detail_contract
inner join included_services on detail_contract_included_services_id = included_services_id
group by detail_contract_included_services_id;

select included_services.*, Amount
from included_services
right join hello on included_services.included_services_id = hello.included_services_id
where Amount = (select max(Amount) from hello); 

-- way 2:
select * 
from (select count(detail_contract_included_services_id) as total, included_services.*
							from detail_contract
							inner join included_services on detail_contract_included_services_id = included_services_id
							group by detail_contract_included_services_id) as temp1
where temp1.total = (select max(temp2.total) from (select count(detail_contract_included_services_id) as total
							from detail_contract
							group by detail_contract_included_services_id) as temp2);

/*Request 14: Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất. 
Thông tin hiển thị bao gồm IDHopDong, TenLoaiDichVu, TenDichVuDiKem, SoLanSuDung.*/
select contract.contract_id, included_services_name, type_services_name, count(detail_contract_included_services_id) as Amount
from detail_contract
inner join contract on contract.contract_id = detail_contract.contract_id
inner join included_services on included_services_id = detail_contract_included_services_id
inner join services on services_id = contract_services_id
inner join type_of_services on type_services_id = services_type_id
group by detail_contract_included_services_id
having Amount = 1;

/*Request 15: Hiển thi thông tin của tất cả nhân viên bao gồm IDNhanVien, HoTen, TrinhDo, TenBoPhan, SoDienThoai, 
DiaChi mới chỉ lập được tối đa 3 hợp đồng từ năm 2018 đến 2019.*/
select employee_id, employee_name, employee_phone, employee_address, level_name, department_name, count(contract_employee_id)
from contract
inner join employee on employee_id = contract_employee_id
inner join `level` on level_id = employee_level_id
inner join department on department_id = employee_department_id
where year(contract_date_start) in (2018, 2019)
group by contract_employee_id
having count(contract_employee_id) < 2; 