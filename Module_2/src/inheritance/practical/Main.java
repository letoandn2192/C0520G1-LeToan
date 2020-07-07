package inheritance.practical;

public class Main {
    public static void main(String[] args) {
        Shape shape1 = new Shape();
        Shape shape2 = new Shape("red", false);
        System.out.println(shape1.toString());
        System.out.println(shape2.toString());

        Circle circle1 = new Circle();
        Circle circle2 = new Circle(2.0);
        Circle circle3 = new Circle(3.0, "red", false);
        System.out.println(circle1.toString());
        System.out.println(circle2.toString());
        System.out.println(circle3.toString());

        Rectangle rectangle1 = new Rectangle();
        Rectangle rectangle2 = new Rectangle(2.0,3.0);
        Rectangle rectangle3 = new Rectangle(3.0,4.0);
        System.out.println(rectangle1.toString());
        System.out.println(rectangle2.toString());
        System.out.println(rectangle3.toString());

        Square square = new Square(2.0,"red", false);
        System.out.println(square.getPerimeter());
    }
}
