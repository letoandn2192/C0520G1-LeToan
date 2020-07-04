package access_modifier_static.exercises;

public class AccessModifier {
    public static void main(String[] args) {
        Circle circle1 = new Circle();
        System.out.println(circle1.getRadius());
        System.out.println(circle1.getArea());

        Circle circle2 = new Circle(3);
        System.out.println(circle2.getRadius());
        System.out.println(circle2.getArea());
    }
}

class Circle{
    private double radius = 1.0;
    private String color = "red";

    public Circle(){}
    public Circle(double radius){
        this.radius = radius;
    }

    public double getRadius() {
        return this.radius;
    }

    public double getArea(){
        return this.radius * this.radius * Math.PI;
    }
}
