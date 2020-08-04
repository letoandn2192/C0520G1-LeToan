package case_study;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public static int checkInputFormat(String input){
        Scanner scanner = new Scanner(System.in);
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(input);
        while (!matcher.matches()) {
            System.out.println("Just only integer!!!");
            input = scanner.nextLine();
            matcher = pattern.matcher(input);
        }
        return Integer.parseInt(input);
    }
}
