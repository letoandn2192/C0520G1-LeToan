package dsa_stack_queue.exercises;

import sun.misc.Queue;

import java.util.*;

public class Palindrome {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your string: ");
        String str = input.nextLine();

        boolean isPalindrome = isPalindrome(str);

        if(isPalindrome){
            System.out.println("This is palindrome");
        }else {
            System.out.println("This is not palindrome");
        }
    }

    public static boolean isPalindrome(String str) {
        Stack<Character> stack = new Stack<>();
        Deque<Character> queue = new LinkedList<>();
        boolean isPalindrome = false;
        for(int i= 0; i < str.length(); i++){
            stack.push(str.charAt(i));
            queue.add(str.charAt(i));
        }
        while (!stack.isEmpty()){
            if(stack.pop().equals(queue.poll())){
                isPalindrome = true;
            }else {
                isPalindrome = false;
                break;
            }
        }
        return isPalindrome;
    }
}
