package vn.codegym.common.validate_service_id;

import org.springframework.beans.factory.annotation.Autowired;
import vn.codegym.model.Employee;
import vn.codegym.model.Services;
import vn.codegym.service.ServicesService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ServiceIdConstraintValidator implements ConstraintValidator<ValidateServiceId, String> {
    @Autowired
    private ServicesService servicesService;

    public final String VALIDATE_SERVICE_ID = "^(DV-\\d{4})$";

    private boolean checkValidateServiceId(String input) {
        Pattern pattern = Pattern.compile(VALIDATE_SERVICE_ID);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    @Override
    public void initialize(ValidateServiceId constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (!checkValidateServiceId(value)) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("ID follow format DV-XXXX with X in (0-9)").addConstraintViolation();
            return false;
        }
        Services service = servicesService.findById(value);
        if (service != null) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Id had been already exists!!!").addConstraintViolation();
            return false;
        }
        return true;
    }
}
