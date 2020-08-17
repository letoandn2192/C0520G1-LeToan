use classicmodels;

select customers.customerNumber, customerName, phone, paymentDate, amount from customers
inner join payments
on payments.customerNumber = customers.customerNumber
where city = 'Las Vegas';

select customers.customerNumber, customers.customerName, orders.orderNumber, orders.status
from customers LEFT JOIN orders
on customers.customerNumber = orders.customerNumber
where orderNumber is null;

select table_name,
	table_rows
from information_schema.tables
where table_schema = 'classicmodels';
