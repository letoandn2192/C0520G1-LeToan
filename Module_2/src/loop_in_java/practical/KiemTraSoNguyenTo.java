package loop_in_java.practical;

import java.util.Scanner;

public class KiemTraSoNguyenTo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập số bạn muốn kiểm tra: ");
        int number = input.nextInt();
        boolean isPrime = true;
        if(number >= 2){
            for(int i = 2; i <= Math.sqrt(number); i++){
                if(number%i == 0){
                    isPrime = false;
                    break;
                }
            }
        }else{
            isPrime = false;
        }
        if(isPrime){
            System.out.println(number + " là số nguyên tố.");
        }else {
            System.out.println(number + " không phải là số nguyên tố.");
        }
    }
}
