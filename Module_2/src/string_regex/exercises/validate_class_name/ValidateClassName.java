package string_regex.exercises.validate_class_name;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateClassName {
    public static boolean checkNameClass(String nameClass) {
        Pattern pattern = Pattern.compile("[ACP]\\d{4}[GHIKLM]");
        Matcher matcher = pattern.matcher(nameClass);
        return matcher.matches();
    }
}
