package models;

import commons.Regex;

import java.io.*;
import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Villa extends Services {
    private String roomStandard;
    private double poolArea;
    private int numberOfFloor;
    private static ArrayList<Villa> villas = new ArrayList<Villa>();

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public void setNumberOfFloor(int numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }

    public static ArrayList<Villa> getVillas() {
        return villas;
    }

    public static void setVillas(ArrayList<Villa> villas) {
        Villa.villas = villas;
    }

    @Override
    public void showInformation() {
        System.out.printf("%-4s%-12s%-30s%-20.2f%-10.2f%-10d%-10s%-10s%-15.2f%-10s", "", super.getId(), super.getNameServices(),
                super.getUsableArea(), super.getRentCost(), super.getMaxPerson(), super.getRentOfType(), this.roomStandard,
                this.poolArea, this.numberOfFloor);
        if (super.getIncludedServices().size() != 0) {
            Iterator<AvailableServices> list = super.getIncludedServices().iterator();
            while (list.hasNext()) {
                AvailableServices services = list.next();
                System.out.print(services.getIncludedServicesName() + "/" + services.getUnit() + "/" + services.getPrice() + " ");
            }
            System.out.println();
        }
    }

    public Villa addNewVilla() {
        Scanner input = new Scanner(System.in);
        List<AvailableServices> includedServices = new ArrayList<>();
        System.out.print("Enter Id: ");
        this.setId(Regex.checkId(input.nextLine()));
        System.out.print("Enter Name Services: ");
        this.setNameServices(Regex.checkNameFormat(input.nextLine()));
        System.out.print("Enter Area: ");
        this.setUsableArea(Regex.checkArea(input.nextDouble()));
        System.out.print("Enter cost: ");
        this.setRentCost(Regex.checkRentCost(input.nextDouble()));
        System.out.print("Enter Maximum Person: ");
        this.setMaxPerson(Regex.checkNumber(input.nextInt()));
        input.nextLine();
        System.out.print("Enter rent type: ");
        this.setRentOfType(Regex.checkNameFormat(input.nextLine()));
        System.out.print("Enter room standard: ");
        this.setRoomStandard(Regex.checkNameFormat(input.nextLine()));
        System.out.print("Enter pool area: ");
        this.setPoolArea(Regex.checkArea(input.nextDouble()));
        System.out.print("Enter number of floor: ");
        this.setNumberOfFloor(Regex.checkNumber(input.nextInt()));
        boolean isContinue = false;
        do {
            System.out.println("Do you want to add included services (Yes or No) ?");
            char confirm = input.next().charAt(0);
            if (confirm == 'Y' || confirm == 'y') {
                String nameIncludedServices;
                input.nextLine();
                boolean isExist;
                do {
                    isExist = false;
                    System.out.println("Enter included services (Karaoke/Massage/Food/Drink/Car): ");
                    nameIncludedServices = Regex.checkRegexIncludedServices(input.nextLine());
                    for (AvailableServices list : includedServices) {
                        if (list.getIncludedServicesName().contains(nameIncludedServices)) {
                            isExist = true;
                            System.out.println("Duplicate!!!");
                        }
                    }
                } while (isExist);
                System.out.println("Enter unit: ");
                int unitIncludedServices = Regex.checkNumber(input.nextInt());
                System.out.println("Enter your price: ");
                double priceIncludedServices = Regex.checkNumber(input.nextDouble());
                includedServices.add(new AvailableServices(nameIncludedServices, unitIncludedServices, priceIncludedServices));
                super.setIncludedServices(includedServices);
                if (includedServices.size() == 5) {
                    break;
                }
            } else {
                isContinue = true;
            }
        } while (!isContinue);

        return this;
    }

    public void createFileVilla() {
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

    public void writeFileVilla(Villa villa) throws FileNotFoundException {
        readFileVilla();
        villas.add(villa);
        try {
            FileWriter myWrite = new FileWriter("D:\\C0520G1-LeToan\\Module2_LeToan\\data\\villa.csv");
            for (Villa value : villas) {
                myWrite.append(String.valueOf(value.getId()));
                myWrite.append(",");
                myWrite.append(value.getNameServices());
                myWrite.append(",");
                myWrite.append(String.valueOf(value.getUsableArea()));
                myWrite.append(",");
                myWrite.append(String.valueOf(value.getRentCost()));
                myWrite.append(",");
                myWrite.append(String.valueOf(value.getMaxPerson()));
                myWrite.append(",");
                myWrite.append(String.valueOf(value.getRentOfType()));
                myWrite.append(",");
                myWrite.append(value.roomStandard);
                myWrite.append(",");
                myWrite.append(String.valueOf(value.poolArea));
                myWrite.append(",");
                myWrite.append(String.valueOf(value.numberOfFloor));
                myWrite.append(",");
                Iterator includedServices = value.getIncludedServices().iterator();
                while (includedServices.hasNext()) {
                    AvailableServices temp = (AvailableServices) includedServices.next();
                    myWrite.append(temp.getIncludedServicesName());
                    myWrite.append(",");
                    myWrite.append(String.valueOf(temp.getUnit()));
                    myWrite.append(",");
                    myWrite.append(String.valueOf(temp.getPrice()));
                    myWrite.append(",");
                }
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

    public static void readFileVilla() throws FileNotFoundException {
        villas.clear();// moi lan doc se clear mang villas de khong bi trung lap
        File myObj = new File("D:\\C0520G1-LeToan\\Module2_LeToan\\data\\villa.csv");
        Scanner myReader = new Scanner(myObj);
        //myReader.nextLine();                                             //skip header line
        while (myReader.hasNextLine()) {
            String[] data = myReader.nextLine().split(",");
            Villa a = new Villa();
            List<AvailableServices> includedServices = new ArrayList<>();
            a.setId(data[0]);
            a.setNameServices(data[1]);
            a.setUsableArea(Double.parseDouble(data[2]));
            a.setRentCost(Double.parseDouble(data[3]));
            a.setMaxPerson(Integer.parseInt(data[4]));
            a.setRentOfType(data[5]);
            a.setRoomStandard(data[6]);
            a.setPoolArea(Double.parseDouble(data[7]));
            a.setNumberOfFloor(Integer.parseInt(data[8]));
            for (int i = 9; i < data.length; i = i + 3) {
                String name = data[i];
                int unit = Integer.parseInt(data[i + 1]);
                double price = Double.parseDouble(data[i + 2]);
                includedServices.add(new AvailableServices(name, unit, price));
            }
            a.setIncludedServices(includedServices);
            villas.add(a);
        }
        myReader.close();
    }
}
