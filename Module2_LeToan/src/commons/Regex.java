package commons;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Regex {
    public static boolean checkRegexId(String id){
        Pattern pattern = Pattern.compile("^((SVVL-|SVHO-|SVRO-)\\d{4})$");
        Matcher matcher = pattern.matcher(id);
        return matcher.matches();
    }

    public static boolean checkRegexNameFormat(String nameServices){
        Pattern pattern = Pattern.compile("^[A-Z][a-z]{1,9}(([ ][A-Z][a-z]{0,9})?)*$");
        Matcher matcher = pattern.matcher(nameServices);
        return matcher.matches();
    }
}
