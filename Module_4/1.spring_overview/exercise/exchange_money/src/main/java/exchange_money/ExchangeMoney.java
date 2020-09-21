package exchange_money;

import exchange.Exchange;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExchangeMoney {

    @GetMapping("")
    public String display1(){
        return "display";
    }

    @GetMapping("1")
    public ModelAndView display2(){
        return new ModelAndView("display2", "exchange", new Exchange());
    }

    @PostMapping(value = "/exchange1")
    public ModelAndView exchange1(@RequestParam String usd, String rate){
        double Usd = Double.parseDouble(usd);
        double Rate = Double.parseDouble(rate);
        double vnd = Usd * Rate;
        return new ModelAndView("display", "vnd", vnd);
    }

//    @RequestMapping(value = "{usd:[0-9]+}")
//    public ModelAndView exchange2(@PathVariable("usd") String usd, @PathVariable("rate") String rate){
//        double Usd = Double.parseDouble(usd);
//        double Rate = Double.parseDouble(rate);
//        double vnd = Usd * Rate;
//        return new ModelAndView("display", "vnd", vnd);
//    }

    @PostMapping("/exchange3")
    public ModelAndView exchange3(@ModelAttribute("exchange") Exchange exchange){
        double Usd = exchange.getUsd();
        double Rate = exchange.getRate();
        double vnd = Usd * Rate;
        return new ModelAndView("display2", "vnd", vnd);
    }
}
