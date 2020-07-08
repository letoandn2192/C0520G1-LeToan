package abstract_and_interface.practical.comparator;

import java.util.Comparator;

public class CircleComparator implements Comparator<Circle> {
//    @Override
//    public int compare(Circle o1, Circle o2) {
//        if(o1.getRadius() > o2.getRadius()){
//            return 1;
//        }else if(o1.getRadius() == o2.getRadius()){
//            return 0;
//        }else {
//            return -1;
//        }
//    }

    @Override
    public int compare(Circle o1, Circle o2) {
        if(o1.getColor().compareTo(o2.getColor()) > 0){
            return 1;
        }else if(o1.getColor().compareTo(o2.getColor()) == 0){
            return 0;
        }else {
            return -1;
        }
    }
}
