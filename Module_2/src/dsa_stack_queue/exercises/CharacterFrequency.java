package dsa_stack_queue.exercises;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CharacterFrequency {
    public static void main(String[] args) {
        TreeMap<Character, Integer> charArray = new TreeMap<Character, Integer>();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your string: ");
        String str = input.nextLine().toLowerCase();
        for (int i = 0; i < str.length(); i++) {
            char temp = str.charAt(i);
            Integer count = charArray.get(temp);
            if (count == null) {
                charArray.put(temp, 1);
            }else {
                count++;
                charArray.put(temp, count);
            }
        }
        System.out.println(charArray);
    }
}
