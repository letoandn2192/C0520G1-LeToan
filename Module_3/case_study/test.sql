/*Request 13: Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng. 
(Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).*/            
select detail_contract_included_services_id, count(detail_contract_included_services_id) as Amount
from detail_contract
group by detail_contract_included_services_id
having Amount is not null;

select monthname(contract_date_start) as `Month`, count(contract_id) as 'Number of Customer',  sum(contract_total_money) Total
from contract
where year(contract_date_start) = 2019
group by month(contract_date_start);
 
 select *
from employee; 

select *
from contract;

delete from employee
where employee_id not in (select contract_employee_id
						from contract
                        where year(contract_date_start) in (2017, 2018, 2019));                       					
select *
from employee; 

select *
from contract;

show variables like '%engine%';


