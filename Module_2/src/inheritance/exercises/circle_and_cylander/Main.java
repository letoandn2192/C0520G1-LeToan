package inheritance.exercises.circle_and_cylander;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle.toString());
        System.out.println("Area: " + circle.getArea());
        System.out.println("Perimeter : " + circle.getPerimeter());

        Cylinder cylinder = new Cylinder();
        System.out.println(cylinder.toString());
        System.out.println("Area: " + cylinder.getArea());
        System.out.println("Perimeter : " + cylinder.getPerimeter());
        System.out.println("Volume: "+cylinder.getVolume());
    }
}
