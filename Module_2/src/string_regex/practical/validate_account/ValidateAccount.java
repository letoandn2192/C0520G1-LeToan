package string_regex.practical.validate_account;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateAccount {
    public static boolean checkValidateAccount(String account){
        Pattern pattern = Pattern.compile("^[_0-9a-z]{6,}$");
        Matcher matcher = pattern.matcher(account);
        return matcher.matches();
    }
}
