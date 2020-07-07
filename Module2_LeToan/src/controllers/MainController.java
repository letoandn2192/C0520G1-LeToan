package controllers;


import models.Villa;

import java.util.Scanner;


public class MainController {
    public void displayMainMenu() {
        Scanner input = new Scanner(System.in);
        int choice;
        System.out.println("Menu");
        System.out.println("1. Add New Services.");
        System.out.println("2. Show Services.");
        System.out.println("3. Add New Customer.");
        System.out.println("4. Show Information of Customer.");
        System.out.println("5. Add New Booking.");
        System.out.println("6. Show Information of Employee.");
        System.out.println("7. Exit.");
        System.out.print("Enter your choice: ");
        choice = input.nextInt();

        switch (choice) {
            case 1:
                addNewServices();
                break;
            case 2:
                showServices();
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                System.exit(0);
            default:
                System.out.println("Invalid value!!!");
        }
    }

    public void addNewServices() {
        Scanner input = new Scanner(System.in);
        System.out.println("1. Add New Villa.");
        System.out.println("2. Add New House.");
        System.out.println("3. Add New Room.");
        System.out.println("4. Back to Menu.");
        System.out.println("5. Exit.");
        System.out.print("Enter your select: ");
        int select = input.nextInt();
        switch (select) {
            case 1:
                Villa villa1 = new Villa().addNewVilla();
                Villa villa2 = new Villa().addNewVilla();
                villa1.createFile();
                villa1.writeFile(villa1);
                villa1.writeFile(villa2);
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                displayMainMenu();
                break;
            case 5:
                System.exit(0);
            default:
                System.out.println("Invalid value.");
        }
    }

    public void showServices(){
        Scanner input = new Scanner(System.in);
        System.out.println("1. Show all Villa.");
        System.out.println("2. Show all House.");
        System.out.println("3. Show all Room.");
        System.out.println("4. Show all Villa Not Duplicate.");
        System.out.println("5. Show all House Not Duplicate.");
        System.out.println("6. Show all Room Not Duplicate.");
        System.out.println("7. Back to Menu.");
        System.out.println("8. Exit.");
        System.out.print("Enter your select: ");
        int select = input.nextInt();
        switch (select) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                displayMainMenu();
                break;
            case 8:
                System.exit(0);
            default:
                System.out.println("Invalid value.");
        }
    }

    public static void main(String[] args) {
        MainController main = new MainController();
        main.displayMainMenu();
    }
}
