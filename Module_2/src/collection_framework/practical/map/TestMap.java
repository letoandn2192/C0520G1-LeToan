package collection_framework.practical.map;

import java.util.*;
import java.util.Iterator;

public class TestMap {
    public static void main(String[] args) {
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Smith", 30);
        hashMap.put("Anderson", 31);
        hashMap.put("Lewis", 29);
        hashMap.put("Cook", 29);
        System.out.println(hashMap);
        for(int i: hashMap.values()){
            System.out.println(i);
        }
        System.out.println("-----------------------------");

        Map<String, Integer> treeMap = new TreeMap<>(hashMap);
        System.out.println(treeMap);
        System.out.println("-----------------------------");

        Map<String,Integer> linkedHashMap = new LinkedHashMap<>(16, 0.75f, false);
        linkedHashMap.put("Helen", 30);
        linkedHashMap.put("Anderson", 31);
        linkedHashMap.put("Lewis", 29);
        linkedHashMap.put("Cook", 29);
        System.out.println(linkedHashMap);
        for(String i: linkedHashMap.keySet()){
            System.out.println(i + " = " + linkedHashMap.get(i));
        }
    }
}
