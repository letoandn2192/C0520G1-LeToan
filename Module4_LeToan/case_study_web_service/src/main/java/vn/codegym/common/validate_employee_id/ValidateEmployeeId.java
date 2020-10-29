package vn.codegym.common.validate_employee_id;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = EmployeeIdConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidateEmployeeId {
    String message() default "Id is invalid !!!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
