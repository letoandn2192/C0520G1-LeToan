package loop_in_java.thuc_hanh;

import java.util.Scanner;

public class TimUCLN {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Tìm UCLN của hai số:");
        System.out.println("Nhập số thứ nhất.");
        int number1 = Math.abs(input.nextInt());
        System.out.println("Nhập số thứ hai.");
        int number2 = Math.abs(input.nextInt());
        int UCLN = 1;
        boolean check = false;
        if(number1 != 0 && number2 != 0){
            while (number2 != 0){
                int modulo = number1 % number2;
                if(modulo == 0){
                    UCLN = number2;
                    check = true;
                }
                number1 = number2;
                number2 = modulo;
            }
            System.out.println(UCLN);
        }else if(number1 == 0 && number2 ==0){
            check = false;
        }else {
            if(number1 == 0){
                UCLN = number2;
                check = true;
            }else {
                UCLN = number1;
                check = true;
            }
        }
        if(check){
            System.out.println("UCLN là " + UCLN);
        }else {
            System.out.println("Không tồn tại UCLN.");
        }
    }
}
