package models;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import java.util.Scanner;

public class Villa extends Services {
    private String roomStandard;
    private double poolArea;
    private int numberOfFloor;
    public Villa(){
       super.includedServices[0] = new Services.AvailableServices("Massage", 1, 1000);
       super.includedServices[1] = new Services.AvailableServices("Karaoke", 1, 500);
       super.includedServices[2] = new Services.AvailableServices("Food", 1, 10);
       super.includedServices[3] = new Services.AvailableServices("Drink", 1, 20);
       super.includedServices[4] = new Services.AvailableServices("Car", 1, 300);
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

//    public String getIncludedServices(){
//        return super.includedServices + super.unit + super.price;
//    }

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
        System.out.printf("%-20s%-10s%-10s", "Included Services", "Unit", "Price");
        System.out.println();
        for (AvailableServices includedService : super.includedServices) {
            System.out.printf("%-20s%-10d%-10.2f", includedService.includedServices, includedService.unit, includedService.price);
            System.out.println();
        }
    }

    public void createVillaFile(){
        try {
            File myObj = new File("E:\\villa.csv");
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

    public void writeToFile(String id, String nameServices){
        try {
            FileWriter myWriter = new FileWriter("E:\\villa.csv");
            myWriter.write(super.id + "," + super.nameServices);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void readFile(){
        try {
            File myObj = new File("E:\\villa.csv");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
