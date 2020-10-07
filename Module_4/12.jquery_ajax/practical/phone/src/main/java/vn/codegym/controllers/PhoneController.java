package vn.codegym.controllers;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import vn.codegym.model.Phone;
import vn.codegym.service.PhoneService;

@Controller
public class PhoneController {
    @Autowired
    private PhoneService phoneService;

    @GetMapping("")
    public String getHomePage() {
        return "list";
    }

    @GetMapping("/create")
    public String showCreatePhoneForm(Model model) {
        model.addAttribute("phone", new Phone());
        return "create";
    }

    @PostMapping("/save")
    public String saveNewPhone(Phone phone, Model model) {
        phoneService.save(phone);
        model.addAttribute("phone", phone);
        return "create";
    }
}
