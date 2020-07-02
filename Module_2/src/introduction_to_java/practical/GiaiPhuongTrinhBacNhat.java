package introduction_to_java.practical;

import java.util.Scanner;

public class GiaiPhuongTrinhBacNhat {
    public static void main(String[] args) {
        System.out.println("Linear Equation Resolver");
        System.out.println("Given a equation as 'a * x + b = 0', please enter constants:");
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập a: ");
        int a = input.nextInt();
        System.out.println("Nhập b: ");
        int b = input.nextInt();
        if(a != 0){
            float result = -(float)b/(float)a;
            System.out.println("Phương Trình Có 1 Nghiệm.");
            System.out.printf("Nghiệm Phương Trình Là: %.2f", result);
        }else {
            if( b == 0){
                System.out.println("Phương Trình Vô Số Nghiệm.");
            }else {
                System.out.println("Phương Trình Vô Nghiệm.");
            }
        }
    }
}
