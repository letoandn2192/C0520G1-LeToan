package introduction_to_java.exercises;

import java.util.Scanner;

public class HienThiLoiChao {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = input.nextLine();
        System.out.println("Name is: " + name);
    }
}
