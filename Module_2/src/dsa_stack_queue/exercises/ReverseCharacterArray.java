package dsa_stack_queue.exercises;

import java.util.Scanner;
import java.util.Stack;

public class ReverseCharacterArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Stack<Character> charArray = new Stack<>();
        System.out.print("Enter your string: ");
        String preStr = input.nextLine();
        for(int i = 0; i < preStr.length(); i++){
            charArray.push(preStr.charAt(i));
        }

        System.out.println();
        System.out.println("pre-reverse: ");
        System.out.println(preStr);
        String afterStr = "";
        int size = charArray.size();
        for(int i = 0; i < size; i++){
            afterStr += charArray.pop();
        }

        System.out.println();
        System.out.println("after-reverse: ");
        System.out.print(afterStr);
    }
}
