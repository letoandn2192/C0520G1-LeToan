package controllers;


import models.Customer;
import models.Employee;
import models.Villa;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


public class MainController {
    public void displayMainMenu() {
        Scanner input = new Scanner(System.in);
        int choice;
        while (true) {
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
                    try {
                        addNewServices();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }

                    break;
                case 2:
                    showServices();
                    break;
                case 3:
                    try {
                        addNewCustomer();
                    } catch (IOException e) {
                        System.out.println("Error in CsvFileWriter !!!");
                        e.printStackTrace();
                    }
                    break;
                case 4:
                    try {
                        showInformationCustomers();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                case 5:
                    try {
                        addNewBooking();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    break;
                case 6:
                    showInformationEmployees();
                    break;
                case 7:
                    System.exit(0);
                default:
                    System.out.println("Invalid value!!!");
            }
        }
    }

    public void opening(){
        try {
            Villa.readFileVilla();
            Customer.readFileCustomer();
            Employee.readFileEmployee();
        } catch (IOException e){
            System.out.println("File not found!!!");
        }
    }

    public void addNewServices() throws FileNotFoundException {
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
                Villa villa = new Villa();
                villa.addNewVilla();
//                villa.createFileVilla();
                villa.writeFileVilla(villa);
                System.out.printf("%-4s%-12s%-30s%-20s%-10s%-10s%-10s%-10s%-15s%-10s%s", "", "Id",
                        "Name", "Villa's Area", "Cost", "Capacity", "Type", "Standard", "Pool's Area", "Floor", "Included Services");
                System.out.println();
                villa.showInformation();
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

    public void showServices() {
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
                System.out.printf("%-4s%-12s%-30s%-20s%-10s%-10s%-10s%-10s%-15s%-10s%s", "", "Id",
                        "Name", "Villa's Area", "Cost", "Capacity", "Type", "Standard", "Pool's Area", "Floor", "Included Services");
                System.out.println();
                for (Villa element : Villa.getVillas()) {
                    element.showInformation();
                }
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                Villa.showVillaName();
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

    public void addNewCustomer() throws IOException {
        Customer.addNewCustomer();
    }

    public void showInformationCustomers() throws FileNotFoundException {
        Customer.showInformation();
    }

    public void addNewBooking() throws IOException {
        Scanner input = new Scanner(System.in);
        Customer.showInformation();
        System.out.println("Choose customer you want: ");
        int chooseCustomer = input.nextInt();
        Customer customer = Customer.getCustomers().get(chooseCustomer - 1);
        System.out.println("Choose services: ");
        System.out.println("1. Booking Villa");
        System.out.println("2. Booking House");
        System.out.println("3. Booking Room");
        System.out.println("Choose services: ");
        int choice = input.nextInt();
        switch (choice) {
            case 1:
                Villa.readFileVilla();
                System.out.printf("%-4s%-12s%-30s%-20s%-10s%-10s%-10s%-10s%-15s%-10s%s", "", "Id",
                        "Name", "Villa's Area", "Cost", "Capacity", "Type", "Standard", "Pool's Area", "Floor", "Included Services");
                System.out.println();
                for (Villa element : Villa.getVillas()) {
                    element.showInformation();
                }
                System.out.println("Choose villa: ");
                int chooseVilla = input.nextInt();
                Villa villa = Villa.getVillas().get(chooseVilla - 1);
                customer.setServices(villa);
                Customer.writeFileCustomer();
                break;
            case 2:
                break;
            case 3:
                break;
            default:

        }
    }

    public void showInformationEmployees(){
        Employee.showInformation();
    }

    public static void main(String[] args) {
        MainController main = new MainController();
        main.opening();
        main.displayMainMenu();
    }
}
