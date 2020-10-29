package vn.codegym.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
import vn.codegym.model.CustomerType;
import vn.codegym.service.ContractService;
import vn.codegym.service.CustomerService;
import vn.codegym.service.CustomerTypeService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerTypeService customerTypeService;

    @Autowired
    private ContractService contractService;

    @ModelAttribute("customerTypeList")
    public List<CustomerType> getCustomerTypeList() {
        return customerTypeService.findAll();
    }

    @GetMapping()
    public ResponseEntity<List<Customer>> getCustomerList() {
        List<Customer> customerList = (List<Customer>) customerService.findAll();
        if (customerList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customerList, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Customer> showCustomerInformation(@PathVariable("id") long id) {
            Customer customer = customerService.findById(id);
            if (customer == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Void> saveNewCustomer(@RequestBody Customer customer) {
        customerService.save(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCustomerInformation(@PathVariable("id") long id) {
            Customer customer = customerService.findById(id);
            if (customer == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            customerService.delete(customer.getCustomerId());
            return new ResponseEntity<>(HttpStatus.OK);
    }




//    @GetMapping
//    public String getCustomerList(@PageableDefault(size = 5) Pageable pageable,
//                                        @RequestParam(value = "inputSearch", defaultValue = "") String inputSearch ,Model model) {
//        Page<Customer> customerList;
//        if ("".equals(inputSearch)) {
//            customerList = customerService.findAll(pageable);
//        } else {
//            customerList = customerService.findByIdAndName(inputSearch, pageable);
//        }
//        model.addAttribute("customerList", customerList);
//        model.addAttribute("inputSearch", inputSearch);
//        return "customer/customer-list";
//    }

//    @GetMapping("/create")
//    public ModelAndView showCreateCustomerForm() {
//        ModelAndView modelAndView = new ModelAndView("customer/customer-create");
//        modelAndView.addObject("customer", new Customer());
//        return modelAndView;
//    }
//
//    @GetMapping("/detail/{id}")
//    public ModelAndView showCustomerInformation(@PathVariable("id") String id) {
//        Customer customer = customerService.findById(id);
//        ModelAndView modelAndView = new ModelAndView("customer/customer-detail");
//        modelAndView.addObject("customer", customer);
//        return modelAndView;
//    }
//
//    @GetMapping("/edit/{id}")
//    public ModelAndView showEditCustomerForm(@PathVariable("id") String id) {
//        Customer customer = customerService.findById(id);
//        ModelAndView modelAndView = new ModelAndView("customer/customer-edit");
//        modelAndView.addObject("customer", customer);
//        return modelAndView;
//    }
//
//    @PostMapping("/update")
//    public String updateCustomerInformation(@Validated(Customer.EditCheck.class) Customer customer, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
//        if (bindingResult.hasErrors()) {
//            return "customer/customer-edit";
//        } else {
//            customerService.save(customer);
//            redirectAttributes.addFlashAttribute("messInform", "Update Successful!!!");
//            return "redirect:/customer";
//        }
//    }
//
//    @GetMapping("/delete/{id}")
//    public ModelAndView showDeleteCustomerForm(@PathVariable("id") String id) {
//        Customer customer = customerService.findById(id);
//        ModelAndView modelAndView = new ModelAndView("customer/customer-delete");
//        modelAndView.addObject("customer", customer);
//        return modelAndView;
//    }
//
//    @PostMapping("/confirm")
//    public String deleteCustomerInformation(Customer customer, RedirectAttributes redirectAttributes) {
//        customerService.delete(customer.getCustomerId());
//        redirectAttributes.addFlashAttribute("messInform", "Delete Successful!!!");
//        return "redirect:/customer";
//    }
//
//    @GetMapping("/customer-service")
//    public String getCustomerUseServiceList(@PageableDefault(size = 5) Pageable pageable,Model model) {
//        Page<Contract> contractList = contractService.findAll(pageable);
//        model.addAttribute("contractList", contractList);
//        return "customer/customerUseService-list";
//    }
//
//    @GetMapping("/search")
//    public ModelAndView showSearchCustomerForm() {
//        ModelAndView modelAndView = new ModelAndView("customer/customer-search");
//        modelAndView.addObject("customerList", customerService.findAll());
//        return modelAndView;
//    }
//
//    @PostMapping("/search")
//    public ModelAndView searchAllField(String id, String name, String birthday, int gender, String idNumber, String email, String phone, String address, int customerType) {
//        ModelAndView modelAndView = new ModelAndView("customer/customer-search");
//        List<Customer> customerList = customerService.searchAllField(name, birthday, phone, email, address, idNumber, customerType, id);
//        modelAndView.addObject("customerList", customerList);
//        return modelAndView;
//    }
}
