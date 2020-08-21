use furama_resort;
/*Request2:	Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên 
bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 ký tự.*/
select *
from employee
where (employee_name like 'H%'
	or employee_name like 'T%'
    or employee_name like 'K%')
    and length(employee_name) <= 15;
    
/*Request 3: Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 
tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.*/
select *
from customer
where year(now())-year(customer_date_of_birth) >= 18
	and year(now())-year(customer_date_of_birth) <= 50
    and customer_address in ('Đà Nẵng', 'Quảng Trị');
    
/*Request 4: Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. 
Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng. 
Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.*/
select customer_id, customer_name, count(contract_customer_id) Amount
from contract
inner join customer on customer_id = contract_customer_id
where customer_type_id = 1
group by customer_name
order by count(contract_customer_id) asc;

/*Request 5: Hiển thị IDKhachHang, HoTen, TenLoaiKhach, IDHopDong, TenDichVu, 
NgayLamHopDong, NgayKetThuc, TongTien (Với TongTien được tính theo công thức như sau: 
ChiPhiThue + SoLuong*Gia, với SoLuong và Giá là từ bảng DichVuDiKem) 
cho tất cả các Khách hàng đã từng đặt phỏng. 
(Những Khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).*/
select customer_id, customer_name, type_customer_name, services_name, contract.contract_id, contract_date_start, 
contract_date_finish, (services_price + included_services_price * included_services_unit) as Total
from customer
left join contract on contract_customer_id = customer_id
left join type_of_customer on customer_type_id = type_customer_id
left join services on services_id = contract_services_id
left join detail_contract on contract.contract_id = detail_contract.contract_id
left join included_services on included_services_id = detail_contract_included_services_id;