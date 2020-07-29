package models;

import commons.Regex;

import java.util.*;

public class Villa extends Services{
    private String roomStandard;
    private double poolArea;
    private int numberOfFloor;
    private String other;
    private static List<Villa> villaList = new ArrayList<>();

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

    public static List<Villa> getVillaList() {
        return villaList;
    }

    public static void setVillaList(List<Villa> villaList) {
        Villa.villaList = villaList;
    }

    @Override
    public void showInformation() {
        System.out.printf("%-4s%-12s%-30s%-20.2f%-10.2f%-10d%-10s%-10s%-15.2f%-10d%-10s", "", super.getId(), super.getNameServices(),
                super.getUsableArea(), super.getRentCost(), super.getMaxPerson(), super.getRentOfType(), this.roomStandard,
                this.poolArea, this.numberOfFloor, this.other);
        if (super.getIncludedServices().size() != 0) {
            Iterator<AvailableServices> list = super.getIncludedServices().iterator();
            while (list.hasNext()) {
                AvailableServices services = list.next();
                System.out.print(services.getIncludedServicesName() + "/" + services.getUnit() + "/" + services.getPrice() + " ");
            }
        }
        System.out.println();
    }

    public static void showVillaName() {
        Set<String> villaList = new TreeSet<>();
        for (Villa element : Villa.villaList) {
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
        super.setId(Regex.checkId(input.nextLine()));
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
