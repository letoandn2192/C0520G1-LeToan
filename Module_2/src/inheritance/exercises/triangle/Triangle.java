package inheritance.exercises.triangle;

public class Triangle extends Shape {
    private float side1;
    private float side2;
    private float side3;

    public Triangle(){
        super();
        this.side1 = 1.0f;
        this.side2 = 1.0f;
        this.side3 = 1.0f;
    }

    public Triangle(float side1, float side2, float side3, String color){
        super(color);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public float getSide1() {
        return side1;
    }

    public void setSide1(float side1) {
        this.side1 = side1;
    }

    public float getSide2() {
        return side2;
    }

    public void setSide2(float side2) {
        this.side2 = side2;
    }

    public float getSide3() {
        return side3;
    }

    public void setSide3(float side3) {
        this.side3 = side3;
    }

    public boolean isTriangle(float side1, float side2, float side3){
        if(side1 <= 0 || side2 <= 0 || side3 <= 0){
            return false;
        }else if((side1 + side2 > side3) && (side2 + side3 > side1) && (side1 + side3 > side2)){
            return true;
        }else {
            return false;
        }
    }

    public float getPerimeter(){
        return this.side1 + this.side2 + this.side3;
    }

    public float getArea(){
        float p = this.getPerimeter() / 2;
        return (float)Math.sqrt(p * (p - this.side1) * (p - this.side2) * (p - this.side3));
    }

    @Override
    public String toString() {
        return "Triangle with 3 side and color " + this.getColor();
    }
}
