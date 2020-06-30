package loop_in_java.bai_tap;

import java.util.Scanner;

public class HienThiCacLoaiHinh {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Menu");
        System.out.println("1. Draw the rectangle.");
        System.out.println("2. Draw the square triangle.");
        System.out.println("3. Draw isosceles triangle.");
        System.out.println("4. Exit.");
        while (true) {
            System.out.println("Enter your choice: ");
            int choice = input.nextInt();
            switch (choice){
                case 1:
                    System.out.println("1. Draw the rectangle.");
                    for(int i = 0; i < 5; i++){
                        for (int j = 0; j <= 10; j++){
                            System.out.print("*");
                        }
                        System.out.println("");
                    }
                    break;
                case 2:
                    System.out.println("2. Draw the square triangle.");
                    for(int i = 0; i < 5; i++){
                        for (int j = 0; j <= 5; j++){
                            if(i >= j){
                                System.out.print("*");
                            }
                        }
                        System.out.println("");
                    }
                    break;
                case 3:
                    System.out.println("3. Draw isosceles triangle.");
                    for (int i = 0; i < 5; i++) {
                        for (int j = 0; j < 5; j++) {
                            if (i+j>3) {
                                System.out.print("* ");
                            }else {
                                System.out.print(" ");
                            }
                        }
                        System.out.println("");
                    }
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Invalid value.");
                    break;
            }
        }
    }
}
