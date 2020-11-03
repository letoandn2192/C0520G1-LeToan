package vn.codegym.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.codegym.model.*;
import vn.codegym.service.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CommonController {
    @Autowired
    private CustomerTypeService customerTypeService;

    @Autowired
    private EducationDegreeService educationDegreeService;

    @Autowired
    private DivisionService divisionService;

    @Autowired
    private PositionService positionService;

    @Autowired
    private RentTypeService rentTypeService;

    @Autowired
    private ServiceTypeService serviceTypeService;

    @Autowired
    private AttachServiceService attachServiceService;

    @GetMapping("/educationDegree")
    public ResponseEntity<List<EducationDegree>> getEducationDegreeList() {
        List<EducationDegree> educationDegreeList = educationDegreeService.findAll();
        if (educationDegreeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(educationDegreeList, HttpStatus.OK);
    }

    @GetMapping("/division")
    public ResponseEntity<List<Division>> getDivisionList() {
        List<Division> divisionList = divisionService.findAll();
        if (divisionList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(divisionList, HttpStatus.OK);
    }

    @GetMapping("/position")
    public ResponseEntity<List<Position>> getPositionList() {
        List<Position> positionList = positionService.findAll();
        if (positionList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(positionList, HttpStatus.OK);
    }

    @GetMapping("/rentType")
    public ResponseEntity<List<RentType>> getRentTypeList() {
        List<RentType> rentTypeList = rentTypeService.findAll();
        if (rentTypeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(rentTypeList, HttpStatus.OK);
    }

    @GetMapping("/serviceType")
    public ResponseEntity<List<ServiceType>> getServiceTypeList() {
        List<ServiceType> serviceTypeList = serviceTypeService.findAll();
        if (serviceTypeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(serviceTypeList, HttpStatus.OK);
    }

    @GetMapping("/customerType")
    public ResponseEntity<List<CustomerType>> getCustomerTypeList() {
        List<CustomerType> customerTypeList = customerTypeService.findAll();
        if (customerTypeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customerTypeList, HttpStatus.OK);
    }

    @GetMapping("/attachService")
    public ResponseEntity<List<AttachService>> getAttachServiceList() {
        List<AttachService> attachServiceList = (List<AttachService>) attachServiceService.findAll();
        if (attachServiceList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(attachServiceList, HttpStatus.OK);
    }
}
