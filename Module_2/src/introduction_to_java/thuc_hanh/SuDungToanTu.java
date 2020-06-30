package introduction_to_java.thuc_hanh;

import java.util.Scanner;

public class SuDungToanTu {
    public static void main(String[] args) {
        float width;
        float height;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the width of rectangle: ");
        width = input.nextFloat();
        System.out.println("Enter the height of rectangle: ");
        height = input.nextFloat();
        float area = width * height;
        System.out.printf("Area of rectangle is: %.1f", area);
    }
}
