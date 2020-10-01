package vn.codegym.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(BookException.class)
    public ModelAndView dispatcherErrorPage() {
        return new ModelAndView("book/error");
    }
}
