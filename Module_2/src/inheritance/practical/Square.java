package inheritance.practical;

public class Square extends Rectangle {
    public Square(){
        super.setLength(1.0);
        super.setWidth(1.0);
    }

    public Square(double size){
        super(size, size);
    }

    public Square(double size, String color, boolean filled){
        super(size, size, color, filled);
    }

    public void setSize(double size){
        super.setLength(size);
        super.setWidth(size);
    }

    public double getSize(){
        return super.getLength();
    }

    @Override
    public void setWidth(double width){
        this.setSize(width);
    }

    @Override
    public void setLength(double length){
        this.setSize(length);
    }

    @Override
    public String toString(){
        return "A Square with color of " + super.getColor() + " and " +
                (super.isFilled()? "filled":"not filled") + " and size "+ this.getSize();
    }
}
