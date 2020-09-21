package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @GetMapping("")
    public String getCalculatorForm() {
        return "display";
    }

    @PostMapping("/calculator")
    public String calculator(@RequestParam("firstOperand") String firstOperand, @RequestParam("secondOperand") String secondOperand,
                             @RequestParam("operator") String operator, Model model) {
        double first = Double.parseDouble(firstOperand);
        double second = Double.parseDouble(secondOperand);
        double result;
        switch (operator) {
            case "+":
                result = first + second;
                model.addAttribute("result", result);
                break;
            case "-":
                result = first - second;
                model.addAttribute("result", result);
                break;
            case "*":
                result = first * second;
                model.addAttribute("result", result);
                break;
            case "/":
                if (second != 0) {
                    result = first / second;
                    model.addAttribute("result", result);
                } else {
                    model.addAttribute("result", "divide by zero");
                }
                break;
            default:
                model.addAttribute("result", "Invalid !!!");
        }
        return "display";
    }
}
