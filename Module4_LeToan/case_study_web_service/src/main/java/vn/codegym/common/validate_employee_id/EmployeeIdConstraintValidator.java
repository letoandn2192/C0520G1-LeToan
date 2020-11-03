//package vn.codegym.common.validate_employee_id;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import vn.codegym.model.Employee;
//import vn.codegym.service.EmployeeService;
//
//import javax.validation.ConstraintValidator;
//import javax.validation.ConstraintValidatorContext;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//public class EmployeeIdConstraintValidator implements ConstraintValidator<ValidateEmployeeId, String> {
//    @Autowired
//    private EmployeeService employeeService;
//
//    public final String VALIDATE_EMPLOYEE_ID = "^(NV-\\d{4})$";
//
//    private boolean checkValidateEmployeeId(String input) {
//        Pattern pattern = Pattern.compile(VALIDATE_EMPLOYEE_ID);
//        Matcher matcher = pattern.matcher(input);
//        return matcher.matches();
//    }
//
//    @Override
//    public void initialize(ValidateEmployeeId constraintAnnotation) {
//
//    }
//
//    @Override
//    public boolean isValid(String value, ConstraintValidatorContext context) {
//        if (!checkValidateEmployeeId(value)) {
//            context.disableDefaultConstraintViolation();
//            context.buildConstraintViolationWithTemplate("ID follow format NV-XXXX with X in (0-9)").addConstraintViolation();
//            return false;
//        }
//        Employee employee = employeeService.findById(value);
//        if (employee != null) {
//            context.disableDefaultConstraintViolation();
//            context.buildConstraintViolationWithTemplate("Id had been already exists!!!").addConstraintViolation();
//            return false;
//        }
//        return true;
//    }
//}
