USE classicmodels;

SELECT customers.customerNumber, customers.customerName, orders.orderNumber, orders.status FROM customers
	INNER JOIN orders
ON customers.customerNumber = orders.customerNumber;

SELECT customers.customerNumber, customers.customerName, orders.orderNumber, orders.status FROM customers
	LEFT JOIN orders ON customers.customerNumber = orders.customerNumber
UNION all
SELECT customers.customerNumber, customers.customerName, orders.orderNumber, orders.status FROM customers
	RIGHT JOIN orders ON customers.customerNumber = orders.customerNumber
WHERE customers.customerNumber IS NULL;

SELECT orders.orderNumber, customers.customerName, orderdetails.priceEach Price
FROM orders
	LEFT JOIN customers ON orders.customerNumber = customers.customerNumber
	LEFT JOIN orderdetails ON orders.orderNumber = orderdetails.orderNumber;