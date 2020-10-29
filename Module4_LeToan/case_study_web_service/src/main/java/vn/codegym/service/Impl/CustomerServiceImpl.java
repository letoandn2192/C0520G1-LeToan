package vn.codegym.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.model.Customer;
import vn.codegym.repository.CustomerRepository;
import vn.codegym.service.CustomerService;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Page<Customer> findByName(String inputSearch, Pageable pageable) {
        return customerRepository.findCustomerByCustomerNameContaining( inputSearch, pageable);
    }

    @Override
    public Iterable<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void delete(long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Page<Customer> search(String input, Pageable pageable) {
        return customerRepository.search(input, pageable);
    }

    @Override
    public List<Customer> searchAllField(String name, String birthday, String phone, String email, String address, String idCard, int type) {
        return customerRepository.searchAllField(name, birthday, phone, email, address, idCard, type);
    }
}
