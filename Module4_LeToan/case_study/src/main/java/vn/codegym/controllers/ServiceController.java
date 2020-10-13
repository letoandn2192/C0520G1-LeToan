package vn.codegym.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.SmartValidator;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.model.RentType;
import vn.codegym.model.ServiceType;
import vn.codegym.model.Services;
import vn.codegym.service.RentTypeService;
import vn.codegym.service.ServiceTypeService;
import vn.codegym.service.ServicesService;

import java.util.List;

@Controller
@RequestMapping("/service")
public class ServiceController {
    @Autowired
    private ServicesService servicesService;

    @Autowired
    private RentTypeService rentTypeService;

    @Autowired
    private ServiceTypeService serviceTypeService;

    @Autowired
    private SmartValidator validator;

    @ModelAttribute("rentTypeList")
    public List<RentType> getRentTypeList() {
        return rentTypeService.findAll();
    }

    @ModelAttribute("serviceTypeList")
    public List<ServiceType> getServiceTypeList() {
        return serviceTypeService.findAll();
    }

    @GetMapping
    public String getServicesList(@PageableDefault(value = 5)Pageable pageable,
                                  @RequestParam(value = "inputSearch", defaultValue = "") String inputSearch, Model model) {
        Page<Services> serviceList;
        if ("".equals(inputSearch)) {
            serviceList = servicesService.findAll(pageable);
        } else {
            serviceList = servicesService.findByIdAndName(inputSearch, pageable);
        }
        model.addAttribute("serviceList", serviceList);
        model.addAttribute("inputSearch", inputSearch);
        return "service/service-list";
    }

    @GetMapping("/create")
    public ModelAndView showCreateServiceForm() {
        ModelAndView modelAndView = new ModelAndView("service/service-create");
        modelAndView.addObject("service", new Services());
        return modelAndView;
    }

    @PostMapping("/save")
    public String saveNewService(@ModelAttribute("service") Services service, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (service.getServiceType().getServiceTypeId() == 1) {
            validator.validate(service, bindingResult, Services.IdCheck.class, Services.VillaCheck.class);
        } else if (service.getServiceType().getServiceTypeId() == 2) {
            validator.validate(service, bindingResult, Services.IdCheck.class, Services.HouseCheck.class);
        } else {
            validator.validate(service, bindingResult, Services.IdCheck.class, Services.RoomCheck.class);
        }
        if (bindingResult.hasErrors()) {
            return "service/service-create";
        } else {
            servicesService.save(service);
            redirectAttributes.addFlashAttribute("messInform", "Create Successful!!!");
            return "redirect:/service";
        }
    }

    @GetMapping("/detail/{id}")
    public ModelAndView showServiceInformation(@PathVariable("id") String id) {
        Services services = servicesService.findById(id);
        ModelAndView modelAndView = new ModelAndView("service/service-detail");
        modelAndView.addObject("service", services);
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditServiceForm(@PathVariable("id") String id) {
        Services services = servicesService.findById(id);
        ModelAndView modelAndView = new ModelAndView("service/service-edit");
        modelAndView.addObject("service", services);
        return modelAndView;
    }

    @PostMapping("/update")
    public String updateServiceInformation(@ModelAttribute("service") Services service, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (service.getServiceType().getServiceTypeId() == 1) {
            validator.validate(service, bindingResult, Services.VillaCheck.class);
        } else if (service.getServiceType().getServiceTypeId() == 2) {
            validator.validate(service, bindingResult, Services.HouseCheck.class);
        } else {
            validator.validate(service, bindingResult, Services.RoomCheck.class);
        }
        if (bindingResult.hasErrors()) {
            return "service/service-edit";
        } else {
            servicesService.save(service);
            redirectAttributes.addFlashAttribute("messInform", "Update Successful!!!");
            return "redirect:/service";
        }
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteServiceForm(@PathVariable("id") String id) {
        Services services = servicesService.findById(id);
        ModelAndView modelAndView = new ModelAndView("service/service-delete");
        modelAndView.addObject("service", services);
        return modelAndView;
    }

    @PostMapping("/confirm")
    public String deleteServiceInformation(Services service, RedirectAttributes redirectAttributes) {
        servicesService.deleteById(service.getServiceId());
        redirectAttributes.addFlashAttribute("messInform", "Delete Successful!!!");
        return "redirect:/service";
    }
}
