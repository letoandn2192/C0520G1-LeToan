package search_algorithm.exercises.binary_search_recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SerialString {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your string: ");
        String str = input.nextLine();
        str += "a";
        String temp = "";
        String result = "";
        for(int i = 0; i < str.length()-1; i++){
            if(str.charAt(i) < str.charAt(i+1)){
                temp += String.valueOf(str.charAt(i));
            }else {
                temp += String.valueOf(str.charAt(i));
                if(temp.length() > result.length()){
                    result = temp;
                }
                temp = "";
            }
        }
        System.out.println(result);
    }
}
