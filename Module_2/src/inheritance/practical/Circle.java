package inheritance.practical;

public class Circle extends Shape{
    private double radius;

    public Circle(){
        this.radius = 1.0;
    }

    public Circle(double radius){
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled){
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea(){
        return this.radius * this.radius * Math.PI;
    }

    public double getPerimeter(){
        return 2 * Math.PI * this.radius;
    }

    @Override
    public String toString(){
        return "A Circle with color of " + super.getColor() + " and " + (super.isFilled()? "filled":"not filled") + " and radius "+ this.radius;
    }
}
