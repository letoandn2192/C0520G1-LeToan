package inheritance.exercises.point_moveablepoint;

public class Point {
    private float x;
    private float y;

    public Point(){
        this.x = 0.0f;
        this.y = 0.0f;
    }

    public Point(float x, float y){
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setXY(float x, float y){
        this.x = x;
        this.y = y;
    }

    public float[] getXY(){
        float[] array = new float[2];
        array[0] = this.getX();
        array[0] = this.getX();
        return array;
    }

    @Override
    public String toString() {
        return "[x,y] = ["+ this.getX() + ", " + this.getY() + "]";
    }
}
