package bo.common_bo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public static final String REGEX_PHONE_NUMBER = "^(090|091|\\(84\\)\\+90|\\(84\\)\\+91)\\d{7}$";
    public static final String REGEX_EMAIL= "^(\\w{3,}@\\w+\\.\\w+)$";
    public static final String REGEX_ID_CARD = "^\\d{9}$";
    public static final String REGEX_INTEGER= "^[-]*\\d+$";
    public static final String REGEX_DOUBLE= "^[-]*\\d+([.]\\d+)?$";
    public static final String REGEX_DATE= "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[1,3-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";

    public static boolean checkRegex(String regexPattern, String input){
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public static boolean checkRegexIdNumber(String input){
        Pattern pattern = Pattern.compile(REGEX_ID_CARD);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public static boolean checkRegexPhoneNumber(String input){
        Pattern pattern = Pattern.compile(REGEX_PHONE_NUMBER);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public static boolean checkRegexEmail(String input){
        Pattern pattern = Pattern.compile(REGEX_EMAIL);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public static boolean checkRegexIntegerNumber(String input){
        Pattern pattern = Pattern.compile(REGEX_INTEGER);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public static boolean checkRegexDoubleNumber(String input) {
        Pattern pattern = Pattern.compile(REGEX_DOUBLE);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public static boolean checkRegexIntegerPositive(String input){
        Pattern pattern = Pattern.compile(REGEX_INTEGER);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches() && (Integer.parseInt(input) > 0);
    }

    public static boolean checkRegexDoublePositive(String input){
        Pattern pattern = Pattern.compile(REGEX_DOUBLE);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches() && (Double.parseDouble(input) > 0);
    }

    public static boolean checkValidateDate(String date) {
        Pattern pattern = Pattern.compile(REGEX_DATE);
        Matcher matcher = pattern.matcher(date);
        return matcher.matches();
    }

    public static String changeFormatDateSQL(String date) {
        String[] array = date.split("/");
        return array[2] +"-"+ array[1] +"-"+ array[0];
    }

    public static String changeFormatDateDisplay(String date) {
        String[] array = date.split("-");
        return array[2] +"/"+ array[1] +"/"+ array[0];
    }
}