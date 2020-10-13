package vn.codegym.common.validate_start_end_day;

import vn.codegym.common.validate_service_id.ServiceIdConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = StartBeforeEndDateConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidateStartBeforeEndDate {
//    String startDate();
//    String endDate();
    String message() default "Invalid !!!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
