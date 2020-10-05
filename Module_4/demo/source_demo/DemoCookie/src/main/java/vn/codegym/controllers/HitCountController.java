package vn.codegym.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("hello")
public class HitCountController {

    @GetMapping("/add")
    public String addHitCount(@CookieValue(value = "haiCookie", defaultValue = "0") Long haiCookie,
                              HttpServletResponse response){
        haiCookie++;

        Cookie cookie = new Cookie("haiCookie", haiCookie.toString());

        cookie.setMaxAge(30*60);

        response.addCookie(cookie);

        return "redirect:/hello";

    }

    @GetMapping
    public String showAllCookie(HttpServletRequest request, Model model){
        Cookie[] cookies = null;

        cookies = request.getCookies();

        model.addAttribute("cookieValue", cookies);
        return "/count/hello";
    }
}
