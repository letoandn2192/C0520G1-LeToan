package inheritance.exercises.circle_and_cylinder;

public class Circle {
    private double radius;
    private String color;
    public Circle(){
        this.radius = 1.0;
        this.color = "red";
    }

    public Circle(double radius, String color){
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getArea(){
        return this.radius * this.radius * Math.PI;
    }

    public double getPerimeter(){
        return 2 * Math.PI * this.radius;
    }

    @Override
    public String toString() {
        return "A circle with radius is " + this.radius + " and color " + this.color;
    }

    @Override
    public boolean equals(Object obj) {
        Circle circle = (Circle) obj;
        if(this.radius == circle.getRadius() && this.color.equals(circle.getColor())){
            return true;
        }else {
            return false;
        }
    }
}
