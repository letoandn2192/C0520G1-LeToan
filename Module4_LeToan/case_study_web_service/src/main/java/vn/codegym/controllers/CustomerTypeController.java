package vn.codegym.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.codegym.model.Customer;
import vn.codegym.model.CustomerType;
import vn.codegym.service.CustomerTypeService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/customerType")
public class CustomerTypeController {
    @Autowired
    private CustomerTypeService customerTypeService;

    @GetMapping()
    public ResponseEntity<List<CustomerType>> getCustomerTypeList() {
        List<CustomerType> customerList = customerTypeService.findAll();
        if (customerList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customerList, HttpStatus.OK);
    }
}
