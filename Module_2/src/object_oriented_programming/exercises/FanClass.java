package object_oriented_programming.exercises;

public class FanClass {
    public static void main(String[] args) {
        Fan fan1 = new Fan();
        Fan fan2 = new Fan();
        fan1.setSpeed(Fan.FAST);
        fan1.setColor("yellow");
        fan1.setOn(true);
        System.out.println(fan1.toString());

        fan2.setSpeed(Fan.MEDIUM);
        fan2.setRadius(5.0);
        fan2.setColor("blue");
        System.out.println(fan2.toString());;
    }
}

class Fan{
    public  static final int SLOW = 1, MEDIUM = 2, FAST = 3;
    private int speed = SLOW;
    private boolean on = false;
    private double radius = 5.0;
    private String color = "blue";

    public Fan() {
    }

    /////////////////////////////////////////SPEED///////////////////////////////////////////
    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    /////////////////////////////////////////STATUS////////////////////////////////////////////
    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    /////////////////////////////////////////RADIUS//////////////////////////////////////////////
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    //////////////////////////////////////////COLOR//////////////////////////////////////////////
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String toString(){
        if(this.on){
            return "Fan is on:\n" + "Speed: " + this.speed + "\nColor: " + this.color +"\nRadius: " + this.radius;
        }else {
            return "Fan is off:\n" + "Color: " + this.color +"\nRadius: " + this.radius;
        }
    }
}
