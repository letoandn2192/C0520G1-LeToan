package case_study;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();
        Scanner input = new Scanner(System.in);
        manager.readFile();
        while (true) {
            System.out.println("********************************MENU*************************************");
            System.out.println("*                            1. Define                                  *");
            System.out.println("*                            2. Look up                                 *");
            System.out.println("*                            3. Drop                                    *");
            System.out.println("*                            4. Exit                                    *");
            System.out.println("*************************************************************************");
            System.out.println("Your choose: ");
            int choose = input.nextInt();
            switch (choose) {
                case 1:
                    manager.define();
                    manager.writeFile();
                    break;
                case 2:
                    manager.lookUp();
                    manager.writeFile();
                    break;
                case 3:
                    manager.drop();
                    manager.writeFile();
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Invalid value!!!");
            }
        }
    }
}
