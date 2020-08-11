package bai_thi;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    private static Scanner input = new Scanner(System.in);
    public static final String REGEX_INTEGER= "^\\d+$";
    public static final String REGEX_DOUBLE= "^\\d+([.]\\d+)?$";
    public static final String REGEX_CODE= "^(SP\\d{5})$";

    public static boolean checkRegex(String regexPattern, String input){
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public static int checkNumberInt(String number) {
        while (!checkRegex(REGEX_INTEGER, number) || Integer.parseInt(number) <= 0) {
            System.out.println("Input must be a positive integer!!!");
            number = input.nextLine();
        }
        return Integer.parseInt(number);
    }

    public static double checkNumberDouble(String number) {
        while (!checkRegex(REGEX_DOUBLE, number) || Double.parseDouble(number) <= 0) {
            System.out.println("Input must be a positive number!!!");
            number = input.nextLine();
        }
        return Double.parseDouble(number);
    }

    public static String checkCode(String code) {
        while (!checkRegex(REGEX_CODE, code)) {
            System.out.println("Enter code again!!!");
            code = input.nextLine();
        }
        return code;
    }

    public static String checkNull(String str) {
        while (str.isEmpty()) {
            System.out.println("Please input !!!");
            str = input.nextLine();
        }
        return str;
    }
}
