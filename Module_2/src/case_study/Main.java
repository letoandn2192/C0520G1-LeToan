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
            System.out.println("*                            4. Add Definition                          *");
            System.out.println("*                            5. Show Dictionary                         *");
            System.out.println("*                            6. Exit                                    *");
            System.out.println("*************************************************************************");
            System.out.println("Your choose: ");
            int choose = Regex.checkInputFormat(input.nextLine());
            switch (choose) {
                case 1:
                    manager.define();
                    break;
                case 2:
                    manager.lookUp();
                    break;
                case 3:
                    manager.drop();
                    break;
                case 4:
                    manager.addDefinition();
                    break;
                case 5:
                    manager.showDictionary();
                    break;
                case 6:
                    manager.writeFile();
                    System.exit(0);
                default:
                    System.out.println("Invalid value!!!");
            }
        }
    }
}
