package inheritance.exercises.point_moveablepoint;

public class Main {
    public static void main(String[] args) {
        MovablePoint move = new MovablePoint(1,1,1,1);
        move.move();
        System.out.println(move.getX());
        System.out.println(move.getY());
        System.out.println(move.getXSpeed());
        System.out.println(move.getYSpeed());
    }
}
