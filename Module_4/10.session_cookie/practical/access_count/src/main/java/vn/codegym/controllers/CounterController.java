package vn.codegym.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import vn.codegym.model.MyCounter;

@Controller
@SessionAttributes("counter")
public class CounterController {
    @ModelAttribute("counter")
    public MyCounter getCounter() {
        return new MyCounter();
    }

    @RequestMapping("")
    public String countQuantityUpdate(@ModelAttribute("counter") MyCounter mycounter) {
        mycounter.increment();
        return "countPage";
    }
}
