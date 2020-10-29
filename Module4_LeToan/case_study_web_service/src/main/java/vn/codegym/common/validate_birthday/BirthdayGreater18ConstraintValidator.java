package vn.codegym.common.validate_birthday;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BirthdayGreater18ConstraintValidator implements ConstraintValidator<ValidateBirthdayGreater18, String> {
    public final String VALIDATE_DATE = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[1,3-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
    private boolean checkValidateDate(String input) {
        Pattern pattern = Pattern.compile(VALIDATE_DATE);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    @Override
    public void initialize(ValidateBirthdayGreater18 constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (!checkValidateDate(value)) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Format is DD/MM/YYYY").addConstraintViolation();
            return false;
        }
        String[] array = value.split("/");
        int year = Calendar.getInstance().get(Calendar.YEAR);
        if ( year - Integer.parseInt(array[2]) < 18) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Not old enough").addConstraintViolation();
            return false;
        }
        return true;
    }
}
