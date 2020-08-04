package controllers;

import commons.FileManager;
import commons.Regex;
import models.*;

import java.util.*;

public class Function {
    public void opening() {
        FileManager.readData();
    }

    public void displayMainMenu() {
        Scanner input = new Scanner(System.in);
        int choice;
        while (true) {
            System.out.println("*************************MENU*****************************");
            System.out.println("*              1. Add New Services.                      *");
            System.out.println("*              2. Show Services.                         *");
            System.out.println("*              3. Add New Customer.                      *");
            System.out.println("*              4. Show Information of Customer.          *");
            System.out.println("*              5. Add New Booking.                       *");
            System.out.println("*              6. Show Information of Employee.          *");
            System.out.println("*              7. Other.                                 *");
            System.out.println("*              8. Exit.                                  *");
            System.out.println("**********************************************************");
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
                    addNewCustomer();
                    break;
                case 4:
                    showInformationCustomers();
                    break;
                case 5:
                    addNewBooking();
                    break;
                case 6:
                    showInformationEmployees();
                    break;
                case 7:
                    other();
                    break;
                case 8:
                    FileManager.writeData();
                    System.exit(0);
                default:
                    System.out.println("Invalid value!!!");
            }
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
                Villa villa = new Villa();
                villa.addNewVilla();
                System.out.printf("%-4s%-12s%-30s%-20s%-10s%-10s%-10s%-10s%-15s%-10s%-10s%s", "", "Id",
                        "Name", "Villa's Area", "Cost", "Capacity", "Type", "Standard", "Pool's Area", "Floor", "Other", "Included Services");
                System.out.println();
                villa.showInformation();
                break;
            case 2:
                House house = new House();
                house.addNewHouse();
                System.out.printf("%-4s%-12s%-30s%-20s%-10s%-10s%-10s%-10s%-8s%-10s%s", "", "Id",
                        "Name", "Villa's Area", "Cost", "Capacity", "Type", "Standard", "Floor", "Other", "Included Services");
                System.out.println();
                house.showInformation();
                break;
            case 3:
                Room room = new Room();
                room.addNewRoom();
                System.out.printf("%-4s%-12s%-30s%-20s%-10s%-10s%-10s%-15s%s", "", "Id",
                        "Name", "Villa's Area", "Cost", "Capacity", "Type", "Free Services", "Included Services");
                System.out.println();
                room.showInformation();
                break;
            case 4:
                displayMainMenu();
                break;
            case 5:
                FileManager.writeData();
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
                System.out.printf("%-4s%-12s%-30s%-20s%-10s%-10s%-10s%-10s%-15s%-10s%-10s%s", "", "Id",
                        "Name", "Villa's Area", "Cost", "Capacity", "Type", "Standard", "Pool's Area", "Floor", "Other", "Included Services");
                System.out.println();
//                for (Services element : Villa.getVillaList()) {
//                    element.showInformation();
//                }
                List<Services> villaList = Villa.getVillaList();
                for (int i = 0; i <  villaList.size(); i++) {
                    System.out.print(i+1);
                    villaList.get(i).showInformation();
                }
                break;
            case 2:
                System.out.printf("%-4s%-12s%-30s%-20s%-10s%-10s%-10s%-10s%-8s%-10s%s", "", "Id",
                        "Name", "Villa's Area", "Cost", "Capacity", "Type", "Standard", "Floor", "Other", "Included Services");
                System.out.println();
                for (Services element : House.getHouseList()) {
                    element.showInformation();
                }
                break;
            case 3:
                System.out.printf("%-4s%-12s%-30s%-20s%-10s%-10s%-10s%-15s%s", "", "Id",
                        "Name", "Villa's Area", "Cost", "Capacity", "Type", "Free Services", "Included Services");
                System.out.println();
                for (Services element : Room.getRoomList()) {
                    element.showInformation();
                }
                break;
            case 4:
                Villa.showVillaName();
                break;
            case 5:
                House.showHouseName();
                break;
            case 6:
                Room.showRoomName();
                break;
            case 7:
                displayMainMenu();
                break;
            case 8:
                FileManager.writeData();
                System.exit(0);
            default:
                System.out.println("Invalid value.");
        }
    }

    public void addNewCustomer() {
        Customer.addNewCustomer();
    }

    public void showInformationCustomers() {
        Customer.showInformation();
    }

    public void addNewBooking() {
        Scanner input = new Scanner(System.in);
        Customer.showInformation();
        System.out.println("Choose customer you want: ");
        int chooseCustomer = Regex.checkInvalidBookingCustomer(input.nextLine());
        Customer customer = Customer.getCustomerList().get(chooseCustomer-1);
        System.out.println("Choose services: ");
        System.out.println("1. Booking Villa");
        System.out.println("2. Booking House");
        System.out.println("3. Booking Room");
        System.out.println("4. Back to Menu");
        System.out.println("Choose services: ");
        int choice = Integer.parseInt(input.nextLine());
        switch (choice) {
            case 1:
                if(Villa.getVillaList().size() != 0) {
                    System.out.printf("%-4s%-12s%-30s%-20s%-10s%-10s%-10s%-10s%-15s%-10s%s", "", "Id",
                            "Name", "Villa's Area", "Cost", "Capacity", "Type", "Standard", "Pool's Area", "Floor", "Included Services");
                    System.out.println();
                    for (Services element : Villa.getVillaList()) {
                        element.showInformation();
                    }
                    System.out.println("Choose villa: ");
                    int chooseVilla = Regex.checkInvalidBookingVilla(input.nextLine());
                    Services villa = Villa.getVillaList().get(chooseVilla - 1);
                    customer.setServices(villa);
                } else {
                    System.out.println("List is empty!!!");
                }
                break;
            case 2:
                if(House.getHouseList().size() != 0) {
                    System.out.printf("%-4s%-12s%-30s%-20s%-10s%-10s%-10s%-10s%-8s%-10s%s", "", "Id",
                            "Name", "House's Area", "Cost", "Capacity", "Type", "Standard", "Floor", "Other", "Included Services");
                    System.out.println();
                    for (Services element : House.getHouseList()) {
                        element.showInformation();
                    }
                    System.out.println("Choose House: ");
                    int chooseHouse = Regex.checkInvalidBookingHouse(input.nextLine());
                    Services house = House.getHouseList().get(chooseHouse - 1);
                    customer.setServices(house);
                } else {
                    System.out.println("List is empty!!!");
                }
                break;
            case 3:
                if(Room.getRoomList().size() != 0) {
                    System.out.printf("%-4s%-12s%-30s%-20s%-10s%-10s%-10s%-15s%s", "", "Id",
                            "Name", "Room's Area", "Cost", "Capacity", "Type", "Free Services", "Included Services");
                    System.out.println();
                    for (Services element : Room.getRoomList()) {
                        element.showInformation();
                    }
                    System.out.println("Choose room: ");
                    int chooseRoom = Regex.checkInvalidBookingRoom(input.nextLine());
                    Services room = Room.getRoomList().get(chooseRoom - 1);
                    customer.setServices(room);
                } else {
                    System.out.println("List is empty!!!");
                }
                break;
            case 4:
                displayMainMenu();
                break;
            default:
                System.out.println("Invalid value!!!");
        }
    }

    public void showInformationEmployees() {
        Employee.showInformation();
    }

    public void other() {
        Scanner input = new Scanner(System.in);
        int select;
        System.out.println("1. Movie theater");
        System.out.println("2. Cabinet");
        System.out.println("Choose your select");
        select = Integer.parseInt(input.nextLine());
        switch (select) {
            case 1:
                Theatre theatre = new Theatre();
                System.out.println("Welcome to Furama theatre!!!");
                if(theatre.getAvailable() == 0){
                    System.out.println("Sorry!!! Ticket sold out!!!");
                } else {
                    System.out.println("Enter your name: ");
                    String name = input.nextLine();
                    System.out.println("How many ticket you want to buy ?");
                    int numberOfTicket = Integer.parseInt(input.nextLine());
                    theatre.buyTicket(name, numberOfTicket);
                }
                break;
            case 2:
                Cabinet cabinet = new Cabinet();
                Employee.showInformation();
                System.out.println("Choose employee: ");
                String chooseEmployee = input.nextLine();
                Employee employee = Employee.getEmployeeList().get(chooseEmployee);
                cabinet.search(employee);
                break;
            default:
                System.out.println("Invalid value!!!");
        }
    }
}
