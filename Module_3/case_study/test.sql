/*Check update*/
SELECT 
    table_name, 
    is_updatable
FROM
    information_schema.views
    
    delimiter //
drop procedure if exists delete_customer_by_id;
create procedure delete_customer_by_id (in id int) 
	begin
		foreign_key_checks = 0;
        delete from customer
        where customer_id = id;
        foreign_key_checks = 1;
    end //
delimiter ;
                            