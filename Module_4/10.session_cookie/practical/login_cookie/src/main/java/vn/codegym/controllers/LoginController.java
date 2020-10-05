package vn.codegym.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import vn.codegym.model.User;
import vn.codegym.service.LoginService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;

    @GetMapping("")
    public String showLoginForm(@CookieValue(value = "setUser", defaultValue = "") String setUser,Model model) {
        Cookie cookie = new Cookie("setUser", setUser);
        model.addAttribute("cookieValue", cookie);
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public ModelAndView checkLogin(@CookieValue(value = "setUser", defaultValue = "") String userName, User user, HttpServletResponse response,
                                   HttpServletRequest request) {
        for (User temp: loginService.findAll()) {
            if (temp.getUserName().equals(user.getUserName()) && temp.getUserName().equals(user.getUserName())) {
                if(temp.getUserName() != null) {
                    userName = temp.getUserName();
                }
                ModelAndView model1 = new ModelAndView("welcome");
                Cookie cookie = new Cookie("setUser", userName);
                cookie.setMaxAge(30*60);
                response.addCookie(cookie);

                Cookie[] cookies = request.getCookies();
                for (Cookie ck: cookies) {
                    if ("setUser".equals(ck.getName())) {
                        model1.addObject("cookieValue", ck);
                        break;
                    }
                }
                model1.addObject("message", "Login success. Welcome ");
                return model1;
            }
        }
        ModelAndView model2 = new ModelAndView("login");
        Cookie cookie = new Cookie("setUser", "");
        model2.addObject("cookieValue", cookie);
        model2.addObject("message", "Login failed. Try again.");
        return model2;
    }
}
