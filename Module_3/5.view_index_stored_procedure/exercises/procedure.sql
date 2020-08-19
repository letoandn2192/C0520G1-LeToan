use my_product;
-- Tạo store procedure xoá sản phẩm theo id
delimiter //
drop procedure if exists get_product_information;
create procedure my_product.get_product_information()
begin
	select *
    from product;
end //

drop procedure if exists add_new_product;
create procedure add_new_product(
	in productCode varchar(15),
    in porductName varchar(50),
    in productPrice decimal(10,2),
    in productAmount int,
    in productDescription text,
    in productStatus varchar(50)
)
	begin
		insert into product (product_code, product_name, product_price, product_amount, product_description, product_status)
        values
        (productCode, porductName, productPrice, productAmount, productDescription, productStatus);
    end //
    
drop procedure if exists edit_price_product;
create procedure edit_price_product(in `index` int, in productPrice decimal(10,2))
	begin
		update product 
        set product_price = productPrice
        where id = `index`;
    end //

drop procedure if exists delete_product;
create procedure delete_product(in `index` int)
	begin
        delete from product
        where id = `index`;
	end //
delimiter ;