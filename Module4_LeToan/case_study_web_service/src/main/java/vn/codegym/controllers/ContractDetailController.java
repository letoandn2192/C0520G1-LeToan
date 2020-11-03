package vn.codegym.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.model.AttachService;
import vn.codegym.model.Contract;
import vn.codegym.model.ContractDetail;
import vn.codegym.service.AttachServiceService;
import vn.codegym.service.ContractDetailService;
import vn.codegym.service.ContractService;

import java.util.Set;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/contract-detail")
public class ContractDetailController {
    @Autowired
    private ContractDetailService contractDetailService;

//    @Autowired
//    private ContractService contractService;
//
//
//    @ModelAttribute("contractList")
//    public Iterable<Contract> getContractList() {
//        return contractService.findAll();
//    }

//    @GetMapping("/detail/{id}")
//    public String getContractDetailList(@PathVariable("id") long id, Model model) {
//        Contract contract = contractService.findById(id);
//        model.addAttribute("contract", contract);
//        model.addAttribute("contractDetailList", contractDetailService.findContractDetailByContract(contract));
//        Set<ContractDetail> temp = contract.getContractDetails();
//        double attachFee = 0;
//        for (ContractDetail contractDetail:temp) {
//            attachFee += contractDetail.getContractDetailQuantity() * contractDetail.getAttachService().getAttachServiceCost();
//        }
//        model.addAttribute("attachFee", attachFee);
//        return "contract-detail/contract-detail-list";
//    }

    @PostMapping("/create")
    public ResponseEntity<Void> createNewContractDetail(@RequestBody ContractDetail contractDetail) {
        contractDetailService.save(contractDetail);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
