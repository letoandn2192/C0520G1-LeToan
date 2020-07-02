package object_oriented_programming.practical;


public class Rectangle {
    double width;
    double height;

    public Rectangle(){
        this.width = 5.0;
        this.height = 7.0;
    }


    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getArea(){
        return this.width * this.height;
    }

    public double getPerimeter(){
        return (this.width + this.height) * 2;
    }

    public String display(){
        return "Rectangle{" + "width =" + this.width + ", height =" + this.height + "}";
    }



    public static void main(String[] args) {
        Rectangle rectangle1 = new Rectangle();
        Rectangle rectangle2 = new Rectangle(6,7);
        double area1 = rectangle1.getArea();
        double perimeter1 = rectangle1.getPerimeter();
        double area2 = rectangle2.getArea();
        double perimeter2 = rectangle2.getPerimeter();
        System.out.println(rectangle1.display() + " Perimeter: " + perimeter1 + " area1: " + area1);
        System.out.println(rectangle2.display() + " Perimeter: " + perimeter2 + " area1: " + area2);
    }
}