package search_algorithm.exercises.max_string;

import java.util.Scanner;

public class MaxString {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your string: ");
        String str = input.nextLine();
        String temp = "";
        String result = "";
        for(int i = 0; i < str.length(); i++){
            temp += String.valueOf(str.charAt(i));
            for(int j = i + 1; j < str.length(); j++){
                if(temp.charAt(temp.length()-1) < str.charAt(j)){
                    temp += String.valueOf(str.charAt(j));
                }
            }
            if(temp.length() > result.length()){
                result = temp;
            }
            temp = "";
        }
        System.out.println(result);
    }
}
