package abstract_and_interface.practical.comparable;

public class Circle implements Comparable<Circle>{
    private double radius;
    private String color;

    public Circle(){
        this.radius = 9.0;
        this.color = "red";
    }

    public Circle(double radius){
        this.radius = radius;
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

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + this.radius +
                ", color='" + this.color + '\'' +
                '}';
    }

    @Override
    public int compareTo(Circle o) {
        return (int)(this.radius - o.getRadius());
    }
}

