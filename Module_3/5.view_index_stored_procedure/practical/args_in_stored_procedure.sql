use classicmodels;


/*argument type IN*/
delimiter //
drop procedure if exists getCustomerInfo;
	create procedure getCustomerInfo(in customer_number int)
	begin
		select *
        from customers
        where customerNumber = customer_number;
	end //
delimiter ;

call getCustomerInfo(175);

/*argument type OUT and IN*/
delimiter //
drop procedure if exists getCustomerInfo;
create procedure getCustomerInfo(in customer_number int, out customer_name varchar(50))
begin
	select customerName
    into customer_name
    from customers
    where customerNumber = customer_number;
end //
delimiter ;

call getCustomerInfo(175, @customer_name);

select @customer_name; 

select customerNumber,creditLimit
from customers;

/*argument type INOUT*/
delimiter //
drop procedure if exists getCustomerInfo;
create procedure getCustomerInfo(in customer_number int, inout total decimal(10,2))
begin
	declare temp decimal(10,2);
	select creditLimit
    into temp
    from customers
    where customerNumber = customer_number;
    
    set total = total + temp;
end //
delimiter ;

set @total = 0;
call getCustomerInfo(175, @total);
select @total;
call getCustomerInfo(412, @total);
select @total;