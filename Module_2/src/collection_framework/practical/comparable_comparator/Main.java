package collection_framework.practical.comparable_comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Student student4 = new Student("Kien", 30, "HT");
        Student student1 = new Student("Nam", 26, "HN");
        Student student2 = new Student("Anh", 38, "HT" );
        Student student3 = new Student("Tung", 31, "HT" );

        List<Student> lists = new ArrayList<>();
        lists.add(student4);
        lists.add(student1);
        lists.add(student2);
        lists.add(student3);

        Collections.sort(lists);
        for (Student student: lists){
            System.out.println(student);
        }
        System.out.println("---------------------------------------");
        Collections.sort(lists, new AgeComparator());
        for (Student student: lists){
            System.out.println(student);
        }
    }
}
