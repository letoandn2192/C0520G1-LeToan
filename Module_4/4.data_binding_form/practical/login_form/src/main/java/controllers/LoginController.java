package controllers;

import model.Login;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import service.UserService;
import service.UserServiceImpl;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @GetMapping("")
    public ModelAndView home() {
        return new ModelAndView("home", "login", new Login());
    }

    @PostMapping("/login")
    public ModelAndView checkLogin(@ModelAttribute("login") Login login) {
        User user = userService.checkLogin(login);
        if (user != null) {
            return new ModelAndView("user", "user", user);
        } else {
            return new ModelAndView("error", "message", "Invalid!!!");
        }
    }
}
