package vn.codegym.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.model.Contract;
import vn.codegym.model.Customer;
import vn.codegym.model.Employee;
import vn.codegym.model.Services;
import vn.codegym.service.ContractService;
import vn.codegym.service.CustomerService;
import vn.codegym.service.EmployeeService;
import vn.codegym.service.ServicesService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private ContractService contractService;


    @GetMapping
    public ResponseEntity<List<Contract>> getContractList() {
        List<Contract> contractList = (List<Contract>) contractService.findAll();
        if (contractList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(contractList, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Contract> getContractInformation(@PathVariable("id") long id) {
        Contract contract = contractService.findById(id);
        if (contract == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(contract, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Void> createNewContract(@RequestBody Contract contract) {
        contractService.save(contract);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/edit/{id}")
    public ResponseEntity<Void> updateContract(@RequestBody Contract contract, @PathVariable("id") long id) {
        Contract currentContract = contractService.findById(id);
        if (currentContract == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        contractService.save(contract);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteContractInformation(@PathVariable("id") long id) {
        Contract contract = contractService.findById(id);
        if (contract == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        contractService.deleteById(contract.getContractId());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
