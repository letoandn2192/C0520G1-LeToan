package vn.codegym.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String getAPage() {
        return "home";
    }

    @GetMapping("/guest")
    public String getGuestPage() {
        return "guest";
    }

    @GetMapping("/member")
    public String getMemberPage() {
        return "member";
    }

    @GetMapping("/admin")
    public String getAdminPage() {
        return "admin";
    }

    @GetMapping("/403")
    public String getErrorPage() {
        return "403Page";
    }

//    @GetMapping("/login")
//    public String getLoginPage() {
//        return "login";
//    }
}
