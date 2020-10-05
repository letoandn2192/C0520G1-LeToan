package vn.codegym.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import vn.codegym.model.Customer;
import vn.codegym.service.CustomerService;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("")
    public ResponseEntity<List<Customer>> getAllCustomer() {
        List<Customer> customerList = customerService.findAll();
        if (customerList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new  ResponseEntity<>(customerList,HttpStatus.OK);
    }

    @GetMapping(value = "/view/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> getCustomerInfo(@PathVariable("id") long id) {
        System.out.println("dsbfnsd");
        Customer customer = customerService.findById(id);
        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new  ResponseEntity<>(customer, HttpStatus.OK);
    }

    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createNewCustomer(@RequestBody Customer customer, UriComponentsBuilder ucBuilder) {
        customerService.save(customer);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/view/{id}").buildAndExpand(customer.getCustomerId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping(value = "/edit/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> editustomer(@RequestBody Customer customer, @PathVariable("id") long id) {
        Customer oldCustomer = customerService.findById(id);
        if (oldCustomer == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        oldCustomer.setCustomerName(customer.getCustomerName());
        oldCustomer.setCustomerAge(customer.getCustomerAge());
        oldCustomer.setCustomerAddress(customer.getCustomerAddress());

        customerService.save(oldCustomer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteCustomer(@PathVariable("id") long id) {
        Customer oldCustomer = customerService.findById(id);
        if (oldCustomer == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        customerService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
