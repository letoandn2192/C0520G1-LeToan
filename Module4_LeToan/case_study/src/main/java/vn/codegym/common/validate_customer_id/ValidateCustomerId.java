package vn.codegym.common.validate_customer_id;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CustomerIdConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidateCustomerId {
    String message() default "Id is invalid!!!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
