package dsa_list.exercises.array_list;

import inheritance.exercises.circle_and_cylinder.Circle;

public class MyListTest {
    public static void main(String[] args) {
        MyList array = new MyList();
        array.add(0,new Circle(2,"red"));
        array.add(1,new Circle(3,"blue"));
        array.add(2,new Circle(4,"gray"));
        array.add(2,new Circle(5,"pink"));

        for (int i = 0; i < array.size(); i++){
            System.out.println(array.get(i) + "\t");
        }
        System.out.println();
        //array.remove(4);
        System.out.println("--------------");
        for (int i = 0; i < array.size(); i++){
            System.out.println(array.get(i) + "\t");
        }
        System.out.println();
        System.out.println("--------------");
        System.out.println(array.contains(new Circle(4,"gray")));
        System.out.println("--------------");
        //System.out.println(array.contains(new Circle(2,"red")));
    }
}
