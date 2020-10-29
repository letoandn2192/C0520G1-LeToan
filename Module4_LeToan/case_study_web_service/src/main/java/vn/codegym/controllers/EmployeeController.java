package vn.codegym.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.model.*;
import vn.codegym.service.DivisionService;
import vn.codegym.service.EducationDegreeService;
import vn.codegym.service.EmployeeService;
import vn.codegym.service.PositionService;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DivisionService divisionService;

    @Autowired
    private PositionService positionService;

    @Autowired
    private EducationDegreeService educationDegreeService;

    @ModelAttribute("divisionList")
    public List<Division> getDivisionList() {
        return divisionService.findAll();
    }

    @ModelAttribute("positionList")
    public List<Position> getPositionList() {
        return positionService.findAll();
    }

    @ModelAttribute("educationDegreeList")
    public List<EducationDegree> getEducationDegreeList() {
        return educationDegreeService.findAll();
    }

    @GetMapping
    public String getEmployeeList(@PageableDefault(value = 5) Pageable pageable, @RequestParam(value = "inputSearch", defaultValue = "") String inputSearch, Model model) {
        Page<Employee> employeeList;
        if ("".equals(inputSearch)) {
            employeeList = employeeService.findAll(pageable);
        } else {
            employeeList = employeeService.findByIdAndName(inputSearch, pageable);
        }
        model.addAttribute("employeeList", employeeList);
        model.addAttribute("inputSearch", inputSearch);
        return "employee/employee-list";
    }

    @GetMapping("/create")
    public ModelAndView showCreateEmployeeForm() {
        ModelAndView modelAndView = new ModelAndView("employee/employee-create");
        modelAndView.addObject("employee", new Employee());
        return modelAndView;
    }

    @PostMapping("/save")
    public String saveNewEmployee(@Validated({Employee.IdCheck.class, Employee.EditCheck.class}) Employee employee, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
//            bindingResult.resolveMessageCodes("typeMismatch.employee", "typeMismatch.employee.employeeSalary");
            return "employee/employee-create";
        } else {
            employeeService.save(employee);
            redirectAttributes.addFlashAttribute("messInform", "Create Successful!!!");
            return "redirect:/employee";
        }
    }

    @GetMapping("/detail/{id}")
    public ModelAndView showEmployeeInformation(@PathVariable("id") String id) {
        Employee employee = employeeService.findById(id);
        ModelAndView modelAndView = new ModelAndView("employee/employee-detail");
        modelAndView.addObject("employee", employee);
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditEmployeeForm(@PathVariable("id") String id) {
        Employee employee = employeeService.findById(id);
        ModelAndView modelAndView = new ModelAndView("employee/employee-edit");
        modelAndView.addObject("employee", employee);
        return modelAndView;
    }

    @PostMapping("/update")
    public String updateEmployeeInformation(@Validated(Employee.EditCheck.class) Employee employee, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
//            bindingResult.resolveMessageCodes("typeMismatch.employee", "typeMismatch.employee.employeeSalary");
            return "employee/employee-edit";
        } else {
            employeeService.save(employee);
            redirectAttributes.addFlashAttribute("messInform", "Update Successful!!!");
            return "redirect:/employee";
        }
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteEmployeeForm(@PathVariable("id") String id) {
        Employee employee = employeeService.findById(id);
        ModelAndView modelAndView = new ModelAndView("employee/employee-delete");
        modelAndView.addObject("employee", employee);
        return modelAndView;
    }

    @PostMapping("/confirm")
    public String deleteCustomerInformation(Employee employee, RedirectAttributes redirectAttributes) {
        employeeService.delete(employee.getEmployeeId());
        redirectAttributes.addFlashAttribute("messInform", "Delete Successful!!!");
        return "redirect:/employee";
    }
}
