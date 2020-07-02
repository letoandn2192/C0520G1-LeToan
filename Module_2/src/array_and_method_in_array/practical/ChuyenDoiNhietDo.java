package array_and_method_in_array.practical;

import java.util.Scanner;

public class ChuyenDoiNhietDo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        float tempF;
        float tempC;
        System.out.println("Menu");
        System.out.println("1. Fahrenheit to Celsius");
        System.out.println("2. Celsius to Fahrenheit");
        System.out.println("0. Exit");
        System.out.println("************************");
        while (true){
            System.out.println("Nhập lựa chọn của bạn: ");
            short choice = input.nextShort();
            switch (choice){
                case 0:
                    System.exit(0);
                case 1:
                    System.out.println("1. Fahrenheit to Celsius");
                    System.out.println("Nhập độ F bạn muốn đổi: ");
                    tempF = input.nextFloat();
                    tempC =  (5.0f / 9) * (tempF - 32);
                    System.out.println(tempF + " độ F bằng " + tempC + " độ C");
                    System.out.println("************************");
                    break;
                case 2:
                    System.out.println("2. Celsius to Fahrenheit");
                    System.out.println("Nhập độ C bạn muốn đổi: ");
                    tempC = input.nextFloat();
                    tempF = tempC * 1.8f + 32;
                    System.out.println(tempC + " độ C bằng " + tempF + " độ F");
                    System.out.println("************************");
                    break;
                default:
                    System.out.println("Giá Trị Không Hợp Lệ.");
                    System.out.println("************************");
                    break;
            }
        }
    }
}
