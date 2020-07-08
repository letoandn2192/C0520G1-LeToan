package abstract_and_interface.exercises.interface_resizeable;

public class Main {
    public static void main(String[] args) {
        double percent = Math.floor(Math.random() * 10);
        Shape[] arrayList = new Shape[3];
        arrayList[0] = new Circle(5.0);
        arrayList[1] = new Rectangle(3.0, 5.0);
        arrayList[2] = new Square(5.0);
        System.out.println("percent: " + percent);
        System.out.printf("%-15s%-10s%-10s", "", "Perimeter", "Area");
        System.out.println();

        for (Shape shape: arrayList){
            if(shape instanceof Circle) {
                Circle circle = (Circle) shape;
                System.out.println(circle);
                System.out.printf("%-15s%-10.2f%-10.2f", "Pre-resize:", circle.getPerimeter(), circle.getArea());
                circle.resize(percent);
                System.out.println();
                System.out.printf("%-15s%-10.2f%-10.2f", "After-resize:", circle.getPerimeter(), circle.getArea());
            }else {
                Rectangle rectangle = (Rectangle) shape;
                System.out.println(rectangle);
                System.out.printf("%-15s%-10.2f%-10.2f", "Pre-resize:", rectangle.getPerimeter(), rectangle.getArea());
                rectangle.resize(percent);
                System.out.println();
                System.out.printf("%-15s%-10.2f%-10.2f", "After-resize:", rectangle.getPerimeter(), rectangle.getArea());
            }
            System.out.println();
        }
    }
}
