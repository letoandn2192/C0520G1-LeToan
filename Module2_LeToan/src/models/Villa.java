package models;

import commons.Regex;

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
//    public Villa(){
//       super.includedServices[0] = new AvailableServices("Massage", 1, 1000);
//       super.includedServices[1] = new AvailableServices("Karaoke", 1, 500);
//       super.includedServices[2] = new AvailableServices("Food", 1, 10);
//       super.includedServices[3] = new AvailableServices("Drink", 1, 20);
//       super.includedServices[4] = new AvailableServices("Car", 1, 300);
//    }

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

    public void setUsableArea(double usableArea) {
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
        System.out.println("Area of services: "+super.usableArea + " m2");
        System.out.println("Cost of services: "+super.rentCost);
        System.out.println("Maximum of services: "+super.maxPerson);
        System.out.println("Type of services: "+super.rentOfType);
        System.out.println("Standard of services: "+this.roomStandard);
        System.out.println("Pool of services: "+this.poolArea + " m2");
        System.out.println("Floor of services: "+this.numberOfFloor);
        System.out.printf("%-20s%-10s%s", "Included Services", "Unit", "Price");
        System.out.println();
        for (AvailableServices includedService : super.getIncludedServices()) {
            System.out.printf("%-20s%-10d%.2f$", includedService.includedServicesName, includedService.unit, includedService.price);
            System.out.println();
        }
    }

    public Villa addNewVilla(){
        Scanner input = new Scanner(System.in);
        String id, name, rentOfType, roomStandard;
        int maxPerson, numberOfFloor;
        double area, rentCost, poolArea;
        do {
            System.out.print("Enter Id: ");
            id = input.nextLine();
        }while (!Regex.checkRegexId(id));
        this.setId(id);
        do{
            System.out.print("Enter Name Services: ");
            name = input.nextLine();
        }while (!Regex.checkRegexNameFormat(name));
        this.setNameServices(name);
        do{
            System.out.print("Enter Area: ");
            area = input.nextDouble();
        }while (area < 30.0);
        this.setUsableArea(area);
        do{
            System.out.print("Enter cost: ");
            rentCost = input.nextDouble();
        }while (rentCost <= 0.0);
        this.setRentCost(rentCost);
        do{
            System.out.print("Enter Maximum Person: ");
            maxPerson = input.nextInt();
        }while (maxPerson <= 0);
        this.setMaxPerson(maxPerson);
        rentOfType = input.nextLine();
        do{
            System.out.print("Enter rent type: ");
            rentOfType = input.nextLine();
        }while (!Regex.checkRegexNameFormat(rentOfType));
        this.setRentOfType(rentOfType);
        do {
            System.out.print("Enter room standard: ");
            roomStandard = input.nextLine();
        }while (!Regex.checkRegexNameFormat(roomStandard));
        this.setRoomStandard(roomStandard);
        do {
            System.out.print("Enter pool area: ");
            poolArea = input.nextDouble();
        }while(poolArea < 30);
        this.setPoolArea(poolArea);
        do {
            System.out.print("Enter number of floor: ");
            numberOfFloor = input.nextInt();
        }while (numberOfFloor <= 0);
        this.setNumberOfFloor(numberOfFloor);
        System.out.println("Enter included services (Karaoke/Massage/Food/Drink/Car): ");
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
        final String FILE_HEADER = "id,nameServices,usableArea,rentCost,maxPerson,rentOfType,roomStandard,poolArea,numberOfFloor";
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

    public static void readFile(){
        ArrayList<Villa> villas = new ArrayList<Villa>();
        try {
            File myObj = new File("D:\\C0520G1-LeToan\\Module2_LeToan\\data\\villa.csv");
            Scanner myReader = new Scanner(myObj);
            myReader.nextLine();                                             //skip header line
            while (myReader.hasNextLine()) {
                String[] data = myReader.nextLine().split(",");
                Villa a = new Villa();
                a.setId(data[0]);
                a.setNameServices(data[1]);
                a.setUsableArea(Double.parseDouble(data[2]));
                a.setRentCost(Double.parseDouble(data[3]));
                a.setMaxPerson(Integer.parseInt(data[4]));
                a.setRentOfType(data[5]);
                a.setRoomStandard(data[6]);
                a.setPoolArea(Double.parseDouble(data[7]));
                a.setNumberOfFloor(Integer.parseInt(data[8]));
                villas.add(a);
            }
            myReader.close();
            for(Villa element: villas){
                element.showInformation();
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
