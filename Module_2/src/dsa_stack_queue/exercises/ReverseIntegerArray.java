package dsa_stack_queue.exercises;

import java.util.Stack;

public class ReverseIntegerArray {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("Pre-reverse: ");
        for (int element : array) {
            System.out.print(element + "\t");
        }
        Stack<Integer> stack = new Stack();
        for (int element : array) {
            stack.push(element);
        }
        System.out.println(stack.size());
        for (int i = 0; i < array.length; i++) {
            array[i] = stack.pop();
        }
        System.out.println();
        System.out.println("After-reverse: ");
        for (int element : array) {
            System.out.print(element + "\t");
        }
    }
}
