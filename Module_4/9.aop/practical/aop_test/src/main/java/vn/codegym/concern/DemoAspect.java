package vn.codegym.concern;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.time.LocalDateTime;

@Component
@Aspect
public class DemoAspect {

    @Pointcut("execution(* vn.codegym.controllers.CustomerController.*(..))")
    public void checkController(){};

    @Before("checkController()")
    public void beforeRunController(JoinPoint joinPoint) {
        System.err.println("Start " + joinPoint.getSignature().getName() + " Time: " + LocalDateTime.now());
    }

    @After("checkController()")
    public void afterRunController(JoinPoint joinPoint) {
        System.err.println("End " + joinPoint.getSignature().getName() + " Time: " + LocalDateTime.now());
    }
}
