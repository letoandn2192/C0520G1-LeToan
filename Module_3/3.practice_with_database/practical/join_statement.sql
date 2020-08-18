USE classicmodels;

EXPLAIN SELECT productCode, productName, buyPrice, textDescription FROM products
	INNER JOIN productlines
ON products.productLine = productlines.productLine
WHERE buyPrice > 56.76 AND buyPrice < 95.59;

SELECT table_name, table_rows FROM information_schema.tables
WHERE table_schema = 'classicmodels';

/*Inner Join*/
SELECT customers.customerNumber, customers.customerName, orders.orderNumber, orders.status FROM customers
	INNER JOIN orders
ON customers.customerNumber = orders.customerNumber;

/*Left Join*/
SELECT customers.customerNumber, customers.customerName, orders.orderNumber, orders.status FROM customers
	LEFT JOIN orders
ON customers.customerNumber = orders.customerNumber;

/*Rightorders Join*/
SELECT customers.customerNumber, customers.customerName, orders.orderNumber, orders.status FROM customers
	RIGHT JOIN orders
ON customers.customerNumber = orders.customerNumber;

/*Full Join*/
SELECT customers.customerNumber, customers.customerName, orders.orderNumber, orders.status FROM customers
	LEFT JOIN orders ON customers.customerNumber = orders.customerNumber
UNION ALL
SELECT customers.customerNumber, customers.customerName, orders.orderNumber, orders.status FROM customers
	RIGHT JOIN orders ON customers.customerNumber = orders.customerNumber
WHERE customers.customerNumber IS NULL;

SELECT orders.orderNumber, customers.customerName, orderdetails.priceEach Price
FROM orders
	LEFT JOIN customers ON orders.customerNumber = customers.customerNumber
	LEFT JOIN orderdetails ON orders.orderNumber = orderdetails.orderNumber;
