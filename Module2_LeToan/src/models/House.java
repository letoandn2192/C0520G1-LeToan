package models;

import commons.Regex;

import java.util.*;

public class House extends Services {
    private String roomStandard;
    private int numberOfFloor;
    private String other;
    private static List<Services> houseList = new ArrayList<>();

    public House() {
    }

    public House(String id, String nameServices, double usableArea, double rentCost, int maxPerson, String rentOfType, String roomStandard, int numberOfFloor, String other) {
        super(id, nameServices, usableArea, rentCost, maxPerson, rentOfType);
        this.roomStandard = roomStandard;
        this.numberOfFloor = numberOfFloor;
        this.other = other;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public void setNumberOfFloor(int numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public static void setHouseList(List<Services> houseList) {
        House.houseList = houseList;
    }

    public static List<Services> getHouseList() {
        return houseList;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public int getNumberOfFloor() {
        return numberOfFloor;
    }

    public String getOther() {
        return other;
    }

    @Override
    public void showInformation() {
        System.out.printf("%-4s%-12s%-30s%-20.2f%-10.2f%-10d%-10s%-10s%-8d%-10s", "", super.getId(), super.getNameServices(),
                super.getUsableArea(), super.getRentCost(), super.getMaxPerson(), super.getRentOfType(), this.roomStandard,
                this.numberOfFloor, this.other);
        if (super.getIncludedServices().size() != 0) {
            Iterator<AvailableServices> list = super.getIncludedServices().iterator();
            while (list.hasNext()) {
                AvailableServices services = list.next();
                System.out.print(services.getIncludedServicesName() + "/" + services.getUnit() + "/" + services.getPrice() + " ");
            }
        }
        System.out.println();
    }

    public static void showHouseName() {
        Set<String> houseList = new TreeSet<>();
        for (Services element : House.houseList) {
            houseList.add(element.getNameServices());
        }

        System.out.println("List of house: ");
        for (String element : houseList) {
            System.out.println(element);
        }
    }

    public void addNewHouse() {
        Scanner input = new Scanner(System.in);
        List<AvailableServices> includedServices = new ArrayList<>();
        System.out.print("Enter Id: ");
        super.setId(Regex.checkIdHouse(input.nextLine()));
        System.out.print("Enter Name Services: ");
        super.setNameServices(Regex.checkNameFormat(input.nextLine()));
        System.out.print("Enter Area: ");
        super.setUsableArea(Regex.checkArea(input.nextLine()));
        System.out.print("Enter cost: ");
        super.setRentCost(Regex.checkNumberDouble(input.nextLine()));
        System.out.print("Enter Maximum Person: ");
        super.setMaxPerson(Regex.checkNumberInt(input.nextLine()));
        input.nextLine();
        System.out.print("Enter rent type: ");
        super.setRentOfType(Regex.checkNameFormat(input.nextLine()));
        System.out.print("Enter room standard: ");
        this.setRoomStandard(Regex.checkNameFormat(input.nextLine()));
        System.out.print("Enter number of floor: ");
        this.setNumberOfFloor(Regex.checkNumberInt(input.nextLine()));
        input.nextLine();
        System.out.print("Enter other convenient: ");
        this.setOther(input.nextLine());
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
        houseList.add(this);
    }
}
