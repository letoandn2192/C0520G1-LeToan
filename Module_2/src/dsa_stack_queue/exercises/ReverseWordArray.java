package dsa_stack_queue.exercises;

import java.util.Scanner;
import java.util.Stack;

public class ReverseWordArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Stack<String> wordArray = new Stack<>();
        System.out.print("Enter your string: ");
        String preStr = input.nextLine();
        System.out.println("pre-reverse: " + preStr);
        String[] array = preStr.split(" ");
        for(String value: array){
            wordArray.push(value);
        }

        int size = wordArray.size();
        String afterStr = "";
        for(int i = 0; i < size; i++){
            afterStr += wordArray.pop() + " ";
        }
        System.out.println("After-reverse: " + afterStr);
    }
}
