package inheritance.exercises.circle_and_cylander;

public class Cylinder extends Circle{
    private double height;

    public Cylinder(){
        super();
        this.height = 1.0;
    }

    public Cylinder(double height, double radius, String color){
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getVolume(){
        return this.height * super.getArea();
    }

    @Override
    public double getPerimeter() {
        return 2 * super.getPerimeter() + 2 * ((2 * super.getRadius()) + this.height);
    }

    @Override
    public double getArea() {
        return super.getArea() + 2 * super.getRadius() * this.height;
    }

    @Override
    public String toString() {
        return "A cylinder with radius is " + super.getRadius() + " and color " + super.getColor() + " and height " + this.height;
    }
}
