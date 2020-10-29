package vn.codegym.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.model.Customer;

import java.util.List;

public interface CustomerService {
    Page<Customer> findAll(Pageable pageable);

    Page<Customer> findByName(String inputSearch, Pageable pageable);

    Iterable<Customer> findAll();

    Customer findById(long id);

    void save(Customer customer);

    void delete(long id);

    Page<Customer> search(String input, Pageable pageable);

    List<Customer> searchAllField(String name, String birthday, String phone, String email, String address, String idCard, int type);
}
