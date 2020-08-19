USE classicmodels;

explain select * from customers 
where contactFirstName like 'A%';

select * from customers 
where phone =  '0902';

create index inx_fn on customers(contactFirstName);
create index inx_ln on customers(contactLastName);

SHOW INDEXES FROM customers;

explain select * from customers
where contactFirstName like 'A%';

explain select * from customers 
where contactLastName like '%A%';

alter table customers
drop index inx_fn,
drop index inx_ln;