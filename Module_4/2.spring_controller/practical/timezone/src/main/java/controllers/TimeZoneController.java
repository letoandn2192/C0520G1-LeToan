package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.TimeZone;

@Controller
public class TimeZoneController {

    @GetMapping({"", "/time"})
    public ModelAndView changeTimeZone(@RequestParam(value = "city", defaultValue = "Asia/Ho_Chi_Minh") String city) {
        ModelAndView modelAndView = new ModelAndView("display");
        Date date = new Date();
        TimeZone local = TimeZone.getDefault();
        TimeZone otherLocal = TimeZone.getTimeZone(city);
        long localTime = date.getTime() + (local.getRawOffset() - otherLocal.getRawOffset());
        date.setTime(localTime);
        modelAndView.addObject("date", date);
        modelAndView.addObject("city", city);
        return modelAndView;
    }
}
