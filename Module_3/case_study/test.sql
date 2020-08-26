/*13.	Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng. 
(Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).*/

select * from customer;

select included_services_id, included_services_name, max(temp.total) as Max from	(select count(detail_contract_included_services_id) as total, included_services.*
							from detail_contract
							inner join included_services on detail_contract_included_services_id = included_services_id
							group by detail_contract_included_services_id) as temp;
	


select included_services.*, Amount
from included_services
right join hello on included_services.included_services_id = hello.included_services_id
where Amount = (select max(Amount) from hello);

select * from included_services;



 