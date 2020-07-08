package abstract_and_interface.practical.comparator;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Circle[] circles = new Circle[3];
        circles[0] = new Circle();
        circles[1] = new Circle(7.0, "blue");
        circles[2] = new Circle(3.0, "violet");

        System.out.println("Pre-sort:");
        for(Circle circle: circles){
            System.out.println(circle);
        }

        Comparator circleComparator = new CircleComparator();
        Arrays.sort(circles, circleComparator);

        System.out.println("After-sort:");
        for(Circle circle: circles){
            System.out.println(circle);
        }
    }
}
