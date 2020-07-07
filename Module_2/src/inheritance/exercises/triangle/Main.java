package inheritance.exercises.triangle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Triangle triangle = new Triangle();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter first side: ");
        float side1 = input.nextFloat();
        System.out.println("Enter second side: ");
        float side2 = input.nextFloat();
        System.out.println("Enter third side: ");
        float side3 = input.nextFloat();
        if(triangle.isTriangle(side1, side2, side3)){
            triangle.setSide1(side1);
            triangle.setSide2(side2);
            triangle.setSide3(side3);
            System.out.printf("%s Triangle has perimeter %.2f and area %.2f",triangle.getColor(), triangle.getPerimeter(), triangle.getArea());
        }else {
            System.out.println("This is not a triangle!!!");
        }

    }
}
