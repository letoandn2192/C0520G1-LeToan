package test.hashmap;

import java.util.HashMap;
public class Map {
    public static void main(String[] args) {
        java.util.Map<Student, String> myHashMap = new HashMap<>();
        myHashMap.put(new Student("Hien", 26), "Top 1");
        myHashMap.put(new Student("Vuong", 25), "Top 2");
        myHashMap.put(new Student("Dat", 26), "Top 3");
        myHashMap.put(new Student("Dat", 26), "Top 4");

        for (java.util.Map.Entry<Student, String> entryStudent : myHashMap.entrySet()) {
            System.out.println("key: " + entryStudent.getKey() + " value: " + entryStudent.getValue());
        }
    }
}
