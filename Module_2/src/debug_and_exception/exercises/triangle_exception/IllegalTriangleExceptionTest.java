package debug_and_exception.exercises.triangle_exception;

import java.util.Scanner;

public class IllegalTriangleExceptionTest{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter 3 sides of triangle");
        System.out.println("Enter first side: ");
        double firstSide = input.nextDouble();
        System.out.println("Enter first side: ");
        double secondSide = input.nextDouble();
        System.out.println("Enter first side: ");
        double thirdSide = input.nextDouble();
        try{
            checkTriangle(firstSide, secondSide, thirdSide);
        } catch (IllegalTriangleException e){
            System.out.println("This is not 3 side of a triangle!!!");
            System.out.println(e);
        }
        System.out.println("Program is OK!!!");

    }

    public static void checkTriangle(double a, double b, double c){
        if((a <= 0 || b <= 0 || c <= 0) || (a+b<=c && a+c<=b && b+c<=a)){
            throw new IllegalTriangleException();
        }else{
            System.out.println("This is 3 sides of a triangle!!!");
        }
    }
}
