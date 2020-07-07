package models;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import java.util.Scanner;

public class Villa extends Services {
    private String roomStandard;
    private double poolArea;
    private int numberOfFloor;
    ArrayList<Villa> villas = new ArrayList<Villa>();
    public Villa(){
       super.includedServices[0] = new AvailableServices("Massage", 1, 1000);
       super.includedServices[1] = new AvailableServices("Karaoke", 1, 500);
       super.includedServices[2] = new AvailableServices("Food", 1, 10);
       super.includedServices[3] = new AvailableServices("Drink", 1, 20);
       super.includedServices[4] = new AvailableServices("Car", 1, 300);
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public void setNumberOfFloor(int numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }

    public void setId(String id) {
        super.id = id;
    }

    public void setNameServices(String nameServices) {
        super.nameServices = nameServices;
    }

    public void setUsableArea(int usableArea) {
        super.usableArea = usableArea;
    }

    public void setRentCost(double rentCost) {
        super.rentCost = rentCost;
    }

    public void setMaxPerson(int maxPerson) {
        super.maxPerson = maxPerson;
    }

    public void setRentOfType(String rentOfType) {
        super.rentOfType = rentOfType;
    }

    @Override
    public void showInformation(){
        System.out.println("Your Services:");
        System.out.println("Id of services: "+super.id);
        System.out.println("Name of services: "+super.nameServices);
        System.out.println("Area of services: "+super.usableArea);
        System.out.println("Cost of services: "+super.rentCost);
        System.out.println("Maximum of services: "+super.maxPerson);
        System.out.println("Type of services: "+super.rentOfType);
        System.out.println("Standard of services: "+this.roomStandard);
        System.out.println("Pool of services: "+this.poolArea);
        System.out.println("Floor of services: "+this.numberOfFloor);
        System.out.printf("%-20s%-10s%s", "Included Services", "Unit", "Price");
        System.out.println();
        for (AvailableServices includedService : super.includedServices) {
            System.out.printf("%-20s%-10d%.2f$", includedService.includedServices, includedService.unit, includedService.price);
            System.out.println();
        }
    }

    public Villa addNewVilla(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Id: ");
        String id = input.nextLine();
        this.setId(id);
        System.out.print("Enter Name Services: ");
        String name = input.nextLine();
        this.setNameServices(name);
        System.out.print("Enter Area: ");
        int area = input.nextInt();
        this.setUsableArea(area);
        System.out.print("Enter cost: ");
        double rentCost = input.nextDouble();
        this.setRentCost(rentCost);
        System.out.print("Enter Maximum Person: ");
        int maxPerson = input.nextInt();
        this.setMaxPerson(maxPerson);
        System.out.print("Enter rent type: ");
        String rentOfType = input.nextLine();
        rentOfType = input.nextLine();
        this.setRentOfType(rentOfType);
        System.out.print("Enter room standard: ");
        String roomStandard = input.nextLine();
        this.setRoomStandard(roomStandard);
        System.out.print("Enter pool area: ");
        double poolArea = input.nextDouble();
        this.setPoolArea(poolArea);
        System.out.print("Enter number of floor: ");
        int numberOfFloor = input.nextInt();
        this.setNumberOfFloor(numberOfFloor);
        return this;
    }

    public void createFile(){
        try {
            File myObj = new File("D:\\C0520G1-LeToan\\Module2_LeToan\\data\\villa.csv");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void writeFile(Villa villa){
        final String FILE_HEADER = "1,2,3,4,5,6,7,8,9";
        villas.add(villa);
        try {
            FileWriter myWrite = new FileWriter("D:\\C0520G1-LeToan\\Module2_LeToan\\data\\villa.csv");

            // Write the CSV file header
            myWrite.append(FILE_HEADER);

            // Add a new line separator after the header
            myWrite.append("\n");

            // Write a new Country object list to the CSV file
            for (int i = 0; i < villas.size(); i++) {
                myWrite.append(String.valueOf(villas.get(i).id));
                myWrite.append(",");
                myWrite.append(villas.get(i).nameServices);
                myWrite.append(",");
                myWrite.append(String.valueOf(villas.get(i).usableArea));
                myWrite.append(",");
                myWrite.append(String.valueOf(villas.get(i).rentCost));
                myWrite.append(",");
                myWrite.append(String.valueOf(villas.get(i).maxPerson));
                myWrite.append(",");
                myWrite.append(String.valueOf(villas.get(i).rentOfType));
                myWrite.append(",");
                myWrite.append(villas.get(i).roomStandard);
                myWrite.append(",");
                myWrite.append(String.valueOf(villas.get(i).poolArea));
                myWrite.append(",");
                myWrite.append(String.valueOf(villas.get(i).numberOfFloor));
                myWrite.append(",");
                myWrite.append("\n");
            }
            myWrite.flush();
            myWrite.close();
            System.out.println("CSV file was created successfully !!!");

        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        }

    }
}
