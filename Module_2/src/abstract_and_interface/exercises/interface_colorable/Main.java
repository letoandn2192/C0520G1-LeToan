package abstract_and_interface.exercises.interface_colorable;

public class Main {
    public static void main(String[] args) {
        Shape[] arrayList = new Shape[3];
        arrayList[0] = new Circle(5.0);
        arrayList[1] = new Rectangle(3.0, 5.0);
        arrayList[2] = new Square(5.0);

        for(Shape shape: arrayList){

            if(shape instanceof Square){
                Square square = (Square) shape;
                System.out.println("Area: " + square.getArea() + " and "+ square.howToColor());
            }else if(shape instanceof Rectangle){
                Rectangle rectangle = (Rectangle) shape;
                System.out.println("Area: " + rectangle.getArea());
            }else {
                Circle circle = (Circle) shape;
                System.out.println("Area: " + circle.getArea());
            }
        }
    }
}
