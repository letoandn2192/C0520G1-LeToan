package dsa_stack_queue.exercises;

import java.util.Scanner;
import java.util.Stack;

public class BracketCheck {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter expression: ");
        String str = input.nextLine();
        boolean isWell = isWell(str);

        if(isWell){
            System.out.println("Good Expression");
        }else {
            System.out.println("Not Good Expression");
        }
    }

    public static boolean isWell(String str) {
        Stack<Character> stack = new Stack<>();
        boolean isWell = false;
        char leftBracket = '(';
        char rightBracket = ')';
        int count = 0;
        for(int i =0; i < str.length(); i++){
            if(leftBracket == str.charAt(i)){
                stack.push(leftBracket);
                count++;
            }
            if(rightBracket == str.charAt(i)){
                count--;
                if(!stack.isEmpty()){
                    isWell = true;
                    stack.pop();
                }else {
                    isWell = false;
                }
            }
        }
        if(count!=0){
            isWell = false;
        }
        return isWell;
    }
}
