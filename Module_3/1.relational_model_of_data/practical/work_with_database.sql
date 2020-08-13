use classicmodels;
select * from customers
where customerName = "Atelier Graphique";

select * from customers
where customerName like '%A%';

select * from customers
where city in ('Nantes', 'Las Vegas');

select * from orders
where orderNumber between 10100 and 10110;