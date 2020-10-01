package vn.codegym.concern;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class DemoExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ModelAndView showPageError() {
        return new ModelAndView("customer/error");
    }
}
