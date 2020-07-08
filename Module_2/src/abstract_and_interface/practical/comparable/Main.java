package abstract_and_interface.practical.comparable;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ArrayList<Circle> circles = new ArrayList<Circle>();
        circles.add(new Circle(3.0));
        circles.add(new Circle(9.0));
        circles.add(new Circle(7.0));
        circles.add(new Circle(5.0));


        System.out.println("pre-sort");
        for(int i = 0; i < circles.size(); i++){
            System.out.println(circles.get(i));
        }

        Collections.sort(circles);

        System.out.println("after-sort");
        for(int i = 0; i < circles.size(); i++){
            System.out.println(circles.get(i));
        }
    }
}
