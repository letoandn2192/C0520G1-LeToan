package test;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<String> array = new ArrayList<>();
        array.add("a");
        array.add("f");
        array.add("y");
        array.add("g");
        array.add("e");
        array.add("k");
        array.add("b");
        for (String element: array){
            System.out.print(element + " ");
        }
    }
}