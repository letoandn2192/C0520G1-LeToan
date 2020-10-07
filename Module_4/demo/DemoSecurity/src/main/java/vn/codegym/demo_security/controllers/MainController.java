package vn.codegym.demo_security.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import vn.codegym.demo_security.model.Account;
import vn.codegym.demo_security.service.AccountService;

@Controller
public class MainController {
    @Autowired
    private AccountService accountService;

    @GetMapping({"/", "/home"})
    public String getHomepage() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode("123");
        accountService.save(new Account("hai", password, "USER", true));
        return "home";
    }

    @GetMapping("/hello")
    public String getHelloPage() {
        return "hello";
    }
}
