package test;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Test {
    public static boolean checkRegexId(String id){
        Pattern pattern = Pattern.compile("^((SVVL-|SVHO-|SVRO-)\\d{4})$");
        Matcher matcher = pattern.matcher(id);
        return matcher.matches();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String a;
        boolean b = true;
//        do {
//            System.out.println("dfsdf: ");
//            a = input.nextLine();
//            System.out.println(a);
//            b= checkRegexId(a);
//        }while (b);
        //System.out.println(checkRegexId("SVHO-1111"));

        while(b){
            System.out.println("dfsdf: ");
            a = input.nextLine();
            System.out.println(a);
            if(checkRegexId(a)){
                b = true;
            }else {
                b =false;
            }
        }
    }
}