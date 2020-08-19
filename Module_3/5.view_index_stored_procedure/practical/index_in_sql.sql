use classicmodels;

explain select * from customers
where customerNumber = 175;

explain select * 
from customers
where contactFirstName = 'Jean' 
	and contactLastName = 'King';

/*Way 1:*/
/* create index idx_full_name 
on customers(contactFirstName, contactLastName);*/

/*Way 2:*/
Alter table customers 
add index idx_full_name(contactFirstName, contactLastName) 
using hash;

explain select * 
from customers
where contactFirstName = 'Jean' 
	and contactLastName = 'King';

show indexes 
from customers;

alter table customers 
drop index idx_full_name;

-- drop index idx_full_name on customers;