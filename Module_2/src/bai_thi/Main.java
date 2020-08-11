package bai_thi;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();
        try {
            manager.readFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        manager.displayMenu();
    }
}
