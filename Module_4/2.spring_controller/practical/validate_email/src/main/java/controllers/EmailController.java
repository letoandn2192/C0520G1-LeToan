package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class EmailController {
    public static final String REGEX_EMAIL= "^(\\w{3,}@\\w+\\.\\w+)$";

    private boolean checkValidateEmail(String email) {
        Pattern pattern = Pattern.compile(REGEX_EMAIL);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    @GetMapping({"/", "/home"})
    public String showEmailForm() {
        return "home";
    }

    @PostMapping("/validate")
    public ModelAndView check(@RequestParam("email") String email) {
        if (checkValidateEmail(email)) {
            return new ModelAndView("success", "email", email);
        } else {
            return new ModelAndView("home", "message", "Invalid Email !!!");
        }
    }
}
