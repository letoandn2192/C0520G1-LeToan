package string_regex.exercises.validate_phone_number;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatePhoneNumber {
    public static boolean checkPhoneNumber(String phoneNumber) {
        Pattern pattern = Pattern.compile("\\(\\d{2}\\)\\-\\(0\\d{9}\\)");
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }
}
