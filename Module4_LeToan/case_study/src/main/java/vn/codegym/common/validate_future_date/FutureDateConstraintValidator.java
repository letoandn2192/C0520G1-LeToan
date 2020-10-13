package vn.codegym.common.validate_future_date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FutureDateConstraintValidator implements ConstraintValidator<ValidateFutureDate, String> {
    public final String VALIDATE_DATE = "^(?=\\d{2}([-.,\\/])\\d{2}\\1\\d{4}$)(?:0[1-9]|1\\d|[2][0-8]|29(?!.02.(?!(?!(?:[02468][1-35-79]|[13579][0-13-57-9])00)\\d{2}(?:[02468][048]|[13579][26])))|30(?!.02)|31(?=.(?:0[13578]|10|12))).(?:0[1-9]|1[012]).\\d{4}$";
    private boolean checkValidateDate(String input) {
        Pattern pattern = Pattern.compile(VALIDATE_DATE);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    @Override
    public void initialize(ValidateFutureDate constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (!checkValidateDate(value)) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Format is DD/MM/YYYY").addConstraintViolation();
            return false;
        }
        String[] array = value.split("/");
        LocalDate now = LocalDate.now();
        int day = now.getDayOfMonth();
        int month = now.getMonthValue();
        int year = now.getYear();
        if (Integer.parseInt(array[2]) < year) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Date is invalid").addConstraintViolation();
            return false;
        } else if (Integer.parseInt(array[1]) < month) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Date is invalid").addConstraintViolation();
            return false;
        } else if (Integer.parseInt(array[0]) <= day) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Date is invalid").addConstraintViolation();
            return false;
        }
        return true;
    }
}
