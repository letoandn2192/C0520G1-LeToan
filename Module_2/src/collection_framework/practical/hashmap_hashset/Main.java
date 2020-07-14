package collection_framework.practical.hashmap_hashset;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("Nam",20, "HN");
        Student student2 = new Student("Hu",25, "HN");
        Student student3 = new Student("Hang",22, "HN");

        //HashMap
        Map<Integer, Student> studentMap = new HashMap<>();
        studentMap.put(1, student1);
        studentMap.put(2, student2);
        studentMap.put(3, student3);

        for(Map.Entry<Integer, Student> student: studentMap.entrySet()){
            System.out.println(student);
        }

        System.out.println("------------------------------");
        Set<Student> studentSet = new HashSet<>();
        studentSet.add(student1);
        studentSet.add(student2);
        studentSet.add(student3);

        for(Student student: studentSet){
            System.out.println(student);
        }
    }
}
