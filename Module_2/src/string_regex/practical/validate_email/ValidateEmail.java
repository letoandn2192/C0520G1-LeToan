package string_regex.practical.validate_email;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateEmail {
    public static boolean checkValidateEmail(String email){
        Pattern pattern = Pattern.compile("^(\\w{3,}@\\w{3,}\\.\\w+)$");
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
