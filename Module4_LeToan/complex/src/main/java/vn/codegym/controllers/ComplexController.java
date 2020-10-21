package vn.codegym.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.model.Complex;
import vn.codegym.model.Status;
import vn.codegym.model.Type;
import vn.codegym.service.ComplexService;
import vn.codegym.service.StatusService;
import vn.codegym.service.TypeService;

import java.util.List;

@Controller
public class ComplexController {
    @Autowired
    private ComplexService complexService;

    @Autowired
    private StatusService statusService;

    @Autowired
    private TypeService typeService;

    @ModelAttribute("statusList")
    public List<Status> getStatusList() {
        return statusService.findAll();
    }

    @ModelAttribute("typeList")
    public List<Type> getTypeList() {
        return typeService.findAll();
    }

    @GetMapping("")
    public String getComplexList(Model model) {
        model.addAttribute("complexList", complexService.findAll());
        model.addAttribute("complex", new Complex());
//        for (Status complex: statusService.findAll()) {
//            System.err.println("KH-" + String.format("%04d", complex.getStatusId()));
//            System.err.println("KH-" + String.format("%04d", 100));
//        }
//        model.addAttribute("complexList", complexService.findAllSortFloorDesc());
        return "complex/complex-list";
    }

    @GetMapping("/create")
    public ModelAndView showCreateComplexForm() {
        ModelAndView modelAndView = new ModelAndView("complex/complex-create");
        modelAndView.addObject("complex", new Complex());
        return modelAndView;
    }

    @PostMapping("/save")
    public String createNewComplex(@Validated @ModelAttribute("complex") Complex complex, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        new Complex().validate(complex, bindingResult);
        if (bindingResult.hasErrors()) {
            return "complex/complex-create";
        }
        complexService.save(complex);
        redirectAttributes.addFlashAttribute("messInform", "Create Successful!!!");
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable(value = "id") String id) {
        ModelAndView modelAndView = new ModelAndView("complex/complex-list");
        modelAndView.addObject("complex", complexService.findById(id));
        return modelAndView;
    }

    @GetMapping("/detail/{id}")
    public ModelAndView showComplexInformation(@PathVariable(value = "id") String id) {
        ModelAndView modelAndView = new ModelAndView("complex/complex-detail");
        modelAndView.addObject("complex", complexService.findById(id));
        return modelAndView;
    }

    @PostMapping("/update")
    public String editComplexInformation(@Validated @ModelAttribute("complex") Complex complex, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        new Complex().validate(complex, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("complexList", complexService.findAll());
            return "complex/complex-list";
        }
        complexService.save(complex);
        model.addAttribute("complexList", complexService.findAll());
        redirectAttributes.addFlashAttribute("messInform", "Edit Successful!!!");
        return "complex/complex-list";
    }
}
