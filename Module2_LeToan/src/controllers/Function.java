package controllers;

import commons.FileManager;
import commons.Regex;
import commons.DisplayFormat;
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
            System.out.println(DisplayFormat.mainMenu());
            System.out.print("Enter your choice: ");
            choice = Regex.checkNumberInt(input.nextLine());

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
        System.out.println(DisplayFormat.addServicesMenu());
        System.out.print("Enter your select: ");
        int select = Regex.checkNumberInt(input.nextLine());
        switch (select) {
            case 1:
                Villa villa = new Villa();
                villa.addNewVilla();
                System.out.println(DisplayFormat.villaTitle());
                System.out.println(villa);
                break;
            case 2:
                House house = new House();
                house.addNewHouse();
                System.out.println(DisplayFormat.houseTitle());
                System.out.println(house);
                break;
            case 3:
                Room room = new Room();
                room.addNewRoom();
                System.out.println(DisplayFormat.roomTitle());
                System.out.println(room);
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
        System.out.println(DisplayFormat.showServicesMenu());
        System.out.print("Enter your select: ");
        int select = Regex.checkNumberInt(input.nextLine());
        switch (select) {
            case 1:
                Villa villa = new Villa();
                villa.showInformation();
                break;
            case 2:
                House house = new House();
                house.showInformation();
                break;
            case 3:
                Room room = new Room();
                room.showInformation();
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
        Customer customer = Customer.getCustomerList().get(chooseCustomer - 1);
        System.out.println(DisplayFormat.bookingMenu());
        System.out.println("Choose services: ");
        int choice = Regex.checkNumberInt(input.nextLine());
        switch (choice) {
            case 1:
                Services villa = new Villa();
                villa.showInformation();
                System.out.println("Choose villa: ");
                int chooseVilla = Regex.checkInvalidBookingVilla(input.nextLine());
                villa = Villa.getVillaList().get(chooseVilla - 1);
                customer.setServices(villa);
                break;
            case 2:
                Services house = new House();
                house.showInformation();
                System.out.println("Choose House: ");
                int chooseHouse = Regex.checkInvalidBookingHouse(input.nextLine());
                house = House.getHouseList().get(chooseHouse - 1);
                customer.setServices(house);
                break;
            case 3:
                Services room = new Room();
                room.showInformation();
                System.out.println("Choose room: ");
                int chooseRoom = Regex.checkInvalidBookingRoom(input.nextLine());
                room = Room.getRoomList().get(chooseRoom - 1);
                customer.setServices(room);
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
        System.out.println(DisplayFormat.otherMenu());
        System.out.println("Choose your select");
        select = Regex.checkNumberInt(input.nextLine());
        switch (select) {
            case 1:
                Theatre theatre = new Theatre();
                System.out.println("Welcome to Furama theatre!!!");
                if (theatre.getAvailable() == 0) {
                    System.out.println("Sorry!!! Ticket sold out!!!");
                } else {
                    System.out.println("Now we have " + theatre.getAvailable() + " tickets!!! Do you want to buy ticket ?");
                    char confirm = input.next().toLowerCase().charAt(0);
                    if (confirm == 'y') {
                        System.out.println("Enter your name: ");
                        input.nextLine();
                        String name = input.nextLine();
                        System.out.println("How many ticket you want to buy ?");
                        int numberOfTicket = Regex.checkNumberInt(input.nextLine());
                        theatre.buyTicket(name, numberOfTicket);
                    }
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
