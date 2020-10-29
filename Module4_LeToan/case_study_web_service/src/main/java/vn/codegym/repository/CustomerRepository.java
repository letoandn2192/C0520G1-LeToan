package vn.codegym.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vn.codegym.model.Customer;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Page<Customer> findCustomerByCustomerNameContaining(String name, Pageable pageable);

    @Query("select p from Customer p where p.customerName like %?1%"
            + "or p.customerBirthday like %?1%"
            + "or p.customerPhone like %?1%"
            + "or p.customerEmail like  %?1%"
            + "or p.customerAddress like %?1%"
            + "or p.customerIdCard like %?1%"
            + "or p.customerType.customerTypeName like %?1%")
    Page<Customer> search(String keyword, Pageable pageable);

    @Query("select p from Customer p where p.customerName like %?1%"
            + "and p.customerBirthday like %?2%"
            + "and p.customerPhone like %?3%"
            + "and p.customerEmail like  %?4%"
            + "and p.customerAddress like %?5%"
            + "and p.customerIdCard like %?6%"
            + "and p.customerType.customerTypeName like %?7%")
    List<Customer> searchAllField(String name, String birthday, String phone, String email, String address, String idCard, int type);
}
