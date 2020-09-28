package vn.codegym.customer_spring_boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.customer_spring_boot.model.Customer;
import vn.codegym.customer_spring_boot.repository.CustomerRepository;


@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Customer findOne(int id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

//    @Override
//    public void edit(Customer customer) {
//        customerRepository.s(customer);
//    }

    @Override
    public void delete(int id) {
        customerRepository.deleteById(id);
    }

    @Override
    public long size() {
        return customerRepository.count();
    }
}
