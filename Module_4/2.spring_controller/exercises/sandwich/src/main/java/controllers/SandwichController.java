package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SandwichController {

    @GetMapping("")
    public String getSpice() {
        return "display";
    }

    @PostMapping("/save")
    public String saveSpice(@RequestParam(value = "spice") String[] spice, Model model) {
        StringBuilder result = new StringBuilder("Nothing !!!");
        if (spice.length != 0) {
            result = new StringBuilder();
            for (String element: spice) {
                result.append(" ").append(element);
            }
        }
        model.addAttribute("result", result);
        return "display";
    }
}
