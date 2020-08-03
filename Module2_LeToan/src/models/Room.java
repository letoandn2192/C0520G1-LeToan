package models;

import commons.Regex;

import java.util.*;

public class Room extends Services {
    private String freeServices;
    private static List<Services> roomList = new ArrayList<>();

    public Room() {
    }

    public Room(String id, String nameServices, double usableArea, double rentCost, int maxPerson, String rentOfType, String freeServices) {
        super(id, nameServices, usableArea, rentCost, maxPerson, rentOfType);
        this.freeServices = freeServices;
    }

    public void setFreeServices(String freeServices) {
        this.freeServices = freeServices;
    }

    public String getFreeServices() {
        return freeServices;
    }

    public static void setRoomList(List<Services> roomList) {
        Room.roomList = roomList;
    }

    public static List<Services> getRoomList() {
        return roomList;
    }

    @Override
    public void showInformation() {
        System.out.printf("%-4s%-12s%-30s%-20.2f%-10.2f%-10d%-10s%-15s", "", super.getId(), super.getNameServices(),
                super.getUsableArea(), super.getRentCost(), super.getMaxPerson(), super.getRentOfType(), this.freeServices);
        if (super.getIncludedServices().size() != 0) {
            Iterator<AvailableServices> list = super.getIncludedServices().iterator();
            while (list.hasNext()) {
                AvailableServices services = list.next();
                System.out.print(services.getIncludedServicesName() + "/" + services.getUnit() + "/" + services.getPrice() + " ");
            }
        }
        System.out.println();
    }

    public static void showRoomName() {
        Set<String> roomList = new TreeSet<>();
        for (Services element : Room.roomList) {
            roomList.add(element.getNameServices());
        }

        System.out.println("List of villa: ");
        for (String element : roomList) {
            System.out.println(element);
        }
    }

    public void addNewRoom() {
        Scanner input = new Scanner(System.in);
        List<AvailableServices> includedServices = new ArrayList<>();
        System.out.print("Enter Id: ");
        super.setId(Regex.checkIdRoom(input.nextLine()));
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
        System.out.print("Enter free services: ");
        this.setFreeServices(input.nextLine());
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
        roomList.add(this); // add new room to array list
    }
}
