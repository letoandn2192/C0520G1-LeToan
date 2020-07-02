package object_oriented_programming.exercises;

import java.util.Scanner;

public class QuadraticEquationClass {
    double a;
    double b;
    double c;

    public QuadraticEquationClass(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getDiscriminant(){
        return (this.b * this.b) - 4 * this.a * this.c;
    }

    public double getRoot1(){
        return ((-this.b + Math.pow(this.getDiscriminant(),0.5)) / (2 * a));
    }

    public double getRoot2(){
        return ((-this.b - Math.pow(this.getDiscriminant(),0.5)) / (2 * a));
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Solve Quadratic Equation: ax^2 + bx + c = 0");
        System.out.print("Enter a: ");
        double a = input.nextDouble();
        System.out.print("Enter b: ");
        double b = input.nextDouble();
        System.out.print("Enter c: ");
        double c = input.nextDouble();
        QuadraticEquationClass equation = new QuadraticEquationClass(a, b, c);
        if( a != 0) {
            if (equation.getDiscriminant() > 0) {
                System.out.printf("Equation has 2 roots: %.2f and %.2f", equation.getRoot1(), equation.getRoot2());
            } else if (equation.getDiscriminant() == 0) {
                System.out.printf("Equation has 1 root: %.2f", equation.getRoot1());
            } else {
                System.out.println("Equation has no root");
            }
        }else{
            if(b == 0 && c == 0){
                System.out.println("Equation has many roots");
            }else if(b == 0){
                System.out.println("Equation has no roots");
            }else {
                System.out.printf("Equation has 1 root: %.2f", (-c/b));
            }
        }
    }
}
