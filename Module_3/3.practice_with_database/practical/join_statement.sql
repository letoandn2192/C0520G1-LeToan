use classicmodels;

explain select productCode, productName, buyPrice, textDescription from products
inner join productlines
on products.productLine = productlines.productLine
where buyPrice > 56.76 and buyPrice < 95.59;

select table_name, table_rows from information_schema.tables
where table_schema = 'classicmodels';
