package search_algorithm.practical.algorithm_complexity;

import java.util.Scanner;

public class AlgorithmComplexityTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your string: ");
        String str = input.nextLine();

        int[] frequency = new int[255];
        for(int i = 0; i< str.length(); i++){
            int ascii = (int) str.charAt(i);
            frequency[ascii] += 1;
        }

        int max = 0;
        char character = (char) 255;
        for(int i = 0; i < frequency.length; i++){
            if(frequency[i] > max){
                max = frequency[i];
                character = (char) i;
            }
        }
        System.out.println(character + " " + max);
    }
}
