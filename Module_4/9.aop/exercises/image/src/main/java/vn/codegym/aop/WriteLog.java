package vn.codegym.aop;

        import org.aspectj.lang.JoinPoint;
        import org.aspectj.lang.annotation.After;
        import org.aspectj.lang.annotation.AfterThrowing;
        import org.aspectj.lang.annotation.Aspect;
        import org.aspectj.lang.annotation.Pointcut;
        import org.springframework.stereotype.Component;

        import java.time.LocalDateTime;
        import java.util.Arrays;

@Component
@Aspect
public class WriteLog {
    @Pointcut("execution(* vn.codegym.controllers.ImageController.comment(..))")
    public void log(){};

    @AfterThrowing(value = "log()", throwing = "exception")
    public void writeLog(JoinPoint joinPoint, Throwable exception) {
        System.err.println("Exception thrown because bad word" + joinPoint.getSignature().getName());
        System.err.println(Arrays.toString(joinPoint.getArgs()));
        System.err.println("Time:  " + LocalDateTime.now());
        System.err.println("Exception " + exception);
    }
}
