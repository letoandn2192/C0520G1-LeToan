package vn.codegym.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.model.Admin;
import vn.codegym.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    @GetMapping
    public String showAdminList(Model model) {
        model.addAttribute("adminList", adminService.findAll());
        return "admin/admin-list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("admin", new Admin());
        return "admin/admin-create";
    }

    @PostMapping("/save")
    public String saveAdmin(@Validated Admin admin, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        new Admin().validate(admin, bindingResult);
        if (bindingResult.hasErrors()) {
            bindingResult.resolveMessageCodes("typeMismatch.admin", "typeMismatch.admin.adminAge");
            return "admin/admin-create";
        } else {
            adminService.save(admin);
            redirectAttributes.addFlashAttribute("mess", "Create Successful!!!");
            return "redirect:";
        }
    }
}
