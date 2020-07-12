package dsa_stack_queue.exercises;

import java.util.Scanner;
import java.util.Stack;

public class DecimaToBinary {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        System.out.print("Enter decimal number: ");
        int number = input.nextInt();
        while (number != 0){
            int modulo = number % 2;
            number = number / 2;
            stack.push(modulo);
        }
        int size = stack.size();
        String result = "";
        for(int i = 0; i < size; i++){
            result += stack.pop();
        }
        System.out.printf("%-10s%08d","Binary: ",Integer.parseInt(result));
    }
}
