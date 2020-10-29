//package vn.codegym.common.validate_customer_id;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import vn.codegym.model.Customer;
//import vn.codegym.service.CustomerService;
//
//import javax.validation.ConstraintValidator;
//import javax.validation.ConstraintValidatorContext;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//public class CustomerIdConstraintValidator implements ConstraintValidator<ValidateCustomerId, String> {
//    public final String VALIDATE_CUSTOMER_ID = "^(KH-\\d{4})$";
//
//    @Autowired
//    private CustomerService customerService;
//
//    private boolean checkValidateCustomerId(String input) {
//        Pattern pattern = Pattern.compile(VALIDATE_CUSTOMER_ID);
//        Matcher matcher = pattern.matcher(input);
//        return matcher.matches();
//    }
//
//    @Override
//    public void initialize(ValidateCustomerId constraintAnnotation) {
//
//    }
//
//    @Override
//    public boolean isValid(String value, ConstraintValidatorContext context) {
//        if (!checkValidateCustomerId(value)) {
//            context.disableDefaultConstraintViolation();
//            context.buildConstraintViolationWithTemplate("ID follow format KH-XXXX with X in (0-9)").addConstraintViolation();
//            return false;
//        }
//        Customer customer = customerService.findById(value);
//        if (customer != null) {
//            context.disableDefaultConstraintViolation();
//            context.buildConstraintViolationWithTemplate("Id had been already exists!!!").addConstraintViolation();
//            return false;
//        }
//        return true;
//    }
//}
