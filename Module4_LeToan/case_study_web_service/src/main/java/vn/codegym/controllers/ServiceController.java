package vn.codegym.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.SmartValidator;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.model.Employee;
import vn.codegym.model.RentType;
import vn.codegym.model.ServiceType;
import vn.codegym.model.Services;
import vn.codegym.service.RentTypeService;
import vn.codegym.service.ServiceTypeService;
import vn.codegym.service.ServicesService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/service")
public class ServiceController {
    @Autowired
    private ServicesService servicesService;

    @GetMapping()
    public ResponseEntity<List<Services>> getServiceList() {
        List<Services> servicesList = (List<Services>) servicesService.findAll();
        if (servicesList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(servicesList, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Services> showServiceInformation(@PathVariable("id") long id) {
        Services service = servicesService.findById(id);
        if (service == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(service, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Void> saveNewService(@RequestBody Services service) {
        servicesService.save(service);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/edit/{id}")
    public ResponseEntity<Void> updateServiceInformation(@RequestBody Services service, @PathVariable("id") long id) {
        Services currentService = servicesService.findById(id);
        if (currentService == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        servicesService.save(service);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteServiceInformation(@PathVariable("id") long id) {
        Services service = servicesService.findById(id);
        if (service == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        servicesService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
