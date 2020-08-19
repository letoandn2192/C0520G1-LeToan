use classicmodels;

delimiter //
create procedure getCustomerInfo()
	begin
		select *
        from customers;
	end //
delimiter ;

call getCustomerInfo();