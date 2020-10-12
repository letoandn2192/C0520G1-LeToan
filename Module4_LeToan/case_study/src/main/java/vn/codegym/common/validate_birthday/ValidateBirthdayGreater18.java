package vn.codegym.common.validate_birthday;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = BirthdayGreater18ConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidateBirthdayGreater18 {
    String message() default "You must greater than 18 to book service!!!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
