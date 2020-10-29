package vn.codegym.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.CustomerType;
import vn.codegym.repository.CustomerRepository;
import vn.codegym.repository.CustomerTypeRepository;
import vn.codegym.service.CustomerService;
import vn.codegym.service.CustomerTypeService;

import java.util.List;
@Service
public class CustomerTypeServiceImpl implements CustomerTypeService {
    @Autowired
    private CustomerTypeRepository customerTypeRepository;

    @Override
    public List<CustomerType> findAll() {
        return customerTypeRepository.findAll();
    }
}
