package test;

import java.io.File;

public class Test {
    public static void main(String[] args) {
        File dir = new File("dir");
        File f = new File(dir, "f");
    }
}