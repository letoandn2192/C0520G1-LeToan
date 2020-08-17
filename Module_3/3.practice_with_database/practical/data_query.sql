use classicmodels;

/*Hiển thị ra các sản phẩm có giá lớn hơn 56.76 và số lượng trong kho lớn hơn 10*/
select productCode, productName, buyPrice, quantityInStock from products
where buyPrice > 56.76 and quantityInStock > 10;

/*Bây giờ, nếu bạn muốn lấy productcode, productname và buyprice từ bảng products,
 textdescription từ bảng productlines với điều kiện giá mua nằm trong khoảng từ 56.76 đến 95.59.*/
 
 select productCode, productName, buyPrice, textDescription from products
 inner join productlines
 on productLines.productLine = products.productLine
 where buyPrice > 56.76 and buyPrice < 95.59;
 
 select * from products
 where productLine = 'Classic Cars' or productVendor = 'Min Lin Diecast';