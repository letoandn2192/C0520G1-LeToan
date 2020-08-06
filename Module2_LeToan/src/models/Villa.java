package models;

import commons.DisplayFormat;
import commons.Regex;

import java.util.*;

public class Villa extends Services{
    private String roomStandard;
    private double poolArea;
    private int numberOfFloor;
    private String other;
    private static List<Services> villaList = new ArrayList<>();

    public Villa() {
    }

    public Villa(String id, String nameServices, double usableArea, double rentCost, int maxPerson, String rentOfType, String roomStandard, double poolArea, int numberOfFloor, String other){
        super(id, nameServices, usableArea, rentCost, maxPerson, rentOfType);
        this.roomStandard = roomStandard;
        this.poolArea = poolArea;
        this.numberOfFloor = numberOfFloor;
        this.other = other;
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

    public void setOther(String other) {
        this.other = other;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public int getNumberOfFloor() {
        return numberOfFloor;
    }

    public String getOther() {
        return other;
    }

    public static List<Services> getVillaList() {
        return villaList;
    }

    public static void setVillaList(List<Services> villaList) {
        Villa.villaList = villaList;
    }

    @Override
    public void showInformation() {
        System.out.println(DisplayFormat.villaTitle());
        int count = 0;
        for (Services element: villaList) {
            Villa villa = (Villa) element;
            System.out.printf("%-4d%-12s%-30s%-20.2f%-10.2f%-10d%-10s%-10s%-15.2f%-10d%-10s", ++count, villa.getId(), villa.getNameServices(),
                    villa.getUsableArea(), villa.getRentCost(), villa.getMaxPerson(), villa.getRentOfType(), villa.roomStandard,
                    villa.poolArea, villa.numberOfFloor, villa.other);
            if (villa.getIncludedServices().size() != 0) {
                Iterator<AvailableServices> list = villa.getIncludedServices().iterator();
                while (list.hasNext()) {
                    AvailableServices services = list.next();
                    System.out.print(services.getIncludedServicesName() + "/" + services.getUnit() + "/" + services.getPrice() + " ");
                }
            } else {
                System.out.print("No services");
            }
            System.out.println();
        }
    }

    @Override
    public String toString() {
        return String.format("%-4s%-12s%-30s%-20.2f%-10.2f%-10d%-10s%-10s%-15.2f%-10d%-10s%s", "", super.getId(), super.getNameServices(),
                super.getUsableArea(), super.getRentCost(), super.getMaxPerson(), super.getRentOfType(), this.roomStandard,
                this.poolArea, this.numberOfFloor, this.other, super.getIncludedServices());
    }

    public static void showVillaName() {
        Set<String> villaList = new TreeSet<>();
        for (Services element : Villa.villaList) {
            villaList.add(element.getNameServices());
        }

        System.out.println("List of villa: ");
        for (String element : villaList) {
            System.out.println(element);
        }
    }

    public void addNewVilla() {
        Scanner input = new Scanner(System.in);
        List<AvailableServices> includedServices = new ArrayList<>();
        System.out.print("Enter Id: ");
        super.setId(Regex.checkIdVilla(input.nextLine()));
        System.out.print("Enter Name Services: ");
        super.setNameServices(Regex.checkNameFormat(input.nextLine()));
        System.out.print("Enter Area: ");
        super.setUsableArea(Regex.checkArea(input.nextLine()));
        System.out.print("Enter cost: ");
        super.setRentCost(Regex.checkNumberDouble(input.nextLine()));
        System.out.print("Enter Maximum Person: ");
        super.setMaxPerson(Regex.checkNumberInt(input.nextLine()));
        System.out.print("Enter rent type (Year/Month/Day/Hour): ");
        super.setRentOfType(Regex.checkNameFormat(input.nextLine()));
        System.out.print("Enter room standard (Vip/Normal): ");
        this.setRoomStandard(Regex.checkNameFormat(input.nextLine()));
        System.out.print("Enter pool area: ");
        this.setPoolArea(Regex.checkArea(input.nextLine()));
        System.out.print("Enter number of floor: ");
        this.setNumberOfFloor(Regex.checkNumberInt(input.nextLine()));
        System.out.print("Enter other convenient: ");
        this.setOther(input.nextLine());
        boolean isContinue = false;
        do {
            System.out.println("Do you want to add included services (Yes or No) ?");
            char confirm = input.next().charAt(0);
            input.nextLine();
            if (confirm == 'Y' || confirm == 'y') {
                String nameIncludedServices;
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
                int unitIncludedServices = Regex.checkNumberInt(input.nextLine());
                System.out.println("Enter your price: ");
                double priceIncludedServices = Regex.checkNumberDouble(input.nextLine());
                includedServices.add(new AvailableServices(nameIncludedServices, unitIncludedServices, priceIncludedServices));
                super.setIncludedServices(includedServices);
                if (includedServices.size() == 5) {
                    break;
                }
            } else {
                isContinue = true;
            }
        } while (!isContinue);
        villaList.add(this);
    }
}
