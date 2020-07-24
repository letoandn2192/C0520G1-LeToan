package models;

import commons.Regex;

import java.io.*;
import java.util.*;

public class House extends Services {
    private String roomStandard;
    private int numberOfFloor;
    private String other;
    private static List<House> houses = new ArrayList<>();
    private static final String FILE_PATH = "D:\\C0520G1-LeToan\\Module2_LeToan\\data\\house.csv";

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public void setNumberOfFloor(int numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public static List<House> getHouses() {
        return houses;
    }

    @Override
    public void showInformation(){
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
        for (House element : houses) {
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
        super.setId(Regex.checkId(input.nextLine()));
        System.out.print("Enter Name Services: ");
        super.setNameServices(Regex.checkNameFormat(input.nextLine()));
        System.out.print("Enter Area: ");
        super.setUsableArea(Regex.checkArea(input.nextDouble()));
        System.out.print("Enter cost: ");
        super.setRentCost(Regex.checkRentCost(input.nextDouble()));
        System.out.print("Enter Maximum Person: ");
        super.setMaxPerson(Regex.checkNumber(input.nextInt()));
        input.nextLine();
        System.out.print("Enter rent type: ");
        super.setRentOfType(Regex.checkNameFormat(input.nextLine()));
        System.out.print("Enter room standard: ");
        this.setRoomStandard(Regex.checkNameFormat(input.nextLine()));
        System.out.print("Enter number of floor: ");
        this.setNumberOfFloor(Regex.checkNumber(input.nextInt()));
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
    }

    public void writeFileHouse(House house) {
        houses.add(house);
        try {
            FileWriter fileWriter = new FileWriter(FILE_PATH);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for(House element: houses){
                bufferedWriter.append(element.getId());
                bufferedWriter.append(",");
                bufferedWriter.append(element.getNameServices());
                bufferedWriter.append(",");
                bufferedWriter.append(String.valueOf(element.getUsableArea()));
                bufferedWriter.append(",");
                bufferedWriter.append(String.valueOf(element.getRentCost()));
                bufferedWriter.append(",");
                bufferedWriter.append(String.valueOf(element.getMaxPerson()));
                bufferedWriter.append(",");
                bufferedWriter.append(element.getRentOfType());
                bufferedWriter.append(",");
                bufferedWriter.append(element.roomStandard);
                bufferedWriter.append(",");
                bufferedWriter.append(String.valueOf(element.numberOfFloor));
                bufferedWriter.append(",");
                bufferedWriter.append(element.other);
                bufferedWriter.append(",");
                Iterator includedServices = element.getIncludedServices().iterator();
                while (includedServices.hasNext()) {
                    AvailableServices temp = (AvailableServices) includedServices.next();
                    bufferedWriter.append(temp.getIncludedServicesName());
                    bufferedWriter.append(",");
                    bufferedWriter.append(String.valueOf(temp.getUnit()));
                    bufferedWriter.append(",");
                    bufferedWriter.append(String.valueOf(temp.getPrice()));
                    bufferedWriter.append(",");
                }
                bufferedWriter.append("\n");
            }
            bufferedWriter.flush();
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        public static void readFileHouse() throws IOException {
        houses.clear();// moi lan doc se clear mang houses de khong bi trung lap
            FileReader fileReader = new FileReader(FILE_PATH);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String[] arrayData;
            String data;
        while ((data = bufferedReader.readLine()) != null) {
            arrayData = data.split(",");
            House house = new House();
            List<AvailableServices> includedServices = new ArrayList<>();
            house.setId(arrayData[0]);
            house.setNameServices(arrayData[1]);
            house.setUsableArea(Double.parseDouble(arrayData[2]));
            house.setRentCost(Double.parseDouble(arrayData[3]));
            house.setMaxPerson(Integer.parseInt(arrayData[4]));
            house.setRentOfType(arrayData[5]);
            house.setRoomStandard(arrayData[6]);
            house.setNumberOfFloor(Integer.parseInt(arrayData[7]));
            house.setOther(arrayData[8]);
            for (int i = 9; i < arrayData.length; i = i + 3) {
                String name = arrayData[i];
                int unit = Integer.parseInt(arrayData[i + 1]);
                double price = Double.parseDouble(arrayData[i + 2]);
                includedServices.add(new AvailableServices(name, unit, price));
            }
            house.setIncludedServices(includedServices);
            houses.add(house);
        }
        bufferedReader.close();
        fileReader.close();
    }
}
