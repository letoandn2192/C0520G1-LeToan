use classicmodels;

create view customer_infor as
select *
from customers;

select customerName
from customer_infor;

select table_name, is_updatable
from information_schema.views
where table_schema = 'classicmodels';

drop view customer_infor;