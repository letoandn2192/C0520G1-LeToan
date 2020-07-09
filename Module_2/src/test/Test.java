package test;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Test {
    public static boolean checkRegexId(String id){
        //Pattern pattern = Pattern.compile("^((SVVL-|SVHO-|SVRO-)\\d{4})$");
        Pattern pattern = Pattern.compile("^a$");
        Matcher matcher = pattern.matcher(id);
        return matcher.matches();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String a;
//        boolean b = true;
        do {
            System.out.println("dfsdf: ");
            a = input.nextLine();
            System.out.println(a);
            System.out.println(checkRegexId(a));
        }while (checkRegexId(a));


//        while(b){
//            System.out.println("dfsdf: ");
//            a = input.nextLine();
//            System.out.println(a);
//            if(checkRegexId(a)){
//                b = true;
//            }else {
//                b =false;
//            }
//        }
    }
}