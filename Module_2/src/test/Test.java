package test;

import java.util.Map;
import java.util.TreeMap;

public class Test {
    public static void main(String[] args) {
        Map<String, Student> list = new TreeMap<String, Student>();
        Student student1 = new Student("001", "Toan");
        Student student2 = new Student("002", "Tuan");
        Student student3 = new Student("003", "Hao");

        list.put(student1.getCode(), student1);
        list.put(student2.getCode(), student2);
        list.put(student3.getCode(), student3);
        for (Map.Entry<String, Student> a : list.entrySet()){
            System.out.println(a.getValue());
        }
    }
}