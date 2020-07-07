package inheritance.exercises.point_2d_3d;

public class Point3D extends Point2D{
    private float z;

    public Point3D(){
        super();
        this.z = 0.0f;
    }

    public Point3D(float x, float y, float z){
        super(x,y);
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public void setXYX(float x, float y, float z){
        super.setX(x);
        super.setY(y);
        this.z = z;
    }

    public float[] getXYZ(){
        float[] array = new float[3];
        array[0] = super.getXY()[0];
        array[1] = super.getXY()[1];
        array[2] = this.z;
        return array;
    }

    @Override
    public String toString() {
        return "Point3D has [x,y,z] = " + "["+ super.getX() +", "+ super.getY() +", "+ this.z +"]";
    }
}
