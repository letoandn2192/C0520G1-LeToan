package vn.codegym.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class DispatcherException {

    @ExceptionHandler(BadWordException.class)
    public ModelAndView getErrorPage() {
        return new ModelAndView("views/error");
    }
}
