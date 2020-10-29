package vn.codegym.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomePageController {
    @GetMapping("")
    public String getHomePage() {
        return "home/home";
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model) {
        model.addAttribute("messInform", "Forbidden Page!!!");
        return "home/403Page";
    }
}
