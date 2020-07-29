package commons;

import models.*;

import java.io.*;
import java.util.*;

public class FileManager {
    private static final String VILLA_FILE_PATH = "D:\\C0520G1-LeToan\\Module2_LeToan\\src\\data\\villa.csv";
    private static final String HOUSE_FILE_PATH = "D:\\C0520G1-LeToan\\Module2_LeToan\\src\\data\\house.csv";
    private static final String ROOM_FILE_PATH = "D:\\C0520G1-LeToan\\Module2_LeToan\\src\\data\\room.csv";
    private static final String EMPLOYEE_FILE_PATH = "D:\\C0520G1-LeToan\\Module2_LeToan\\src\\data\\employee.csv";
    private static final String CUSTOMER_FILE_PATH = "D:\\C0520G1-LeToan\\Module2_LeToan\\src\\data\\customer.csv";
    private static final String BOOKING_FILE_PATH = "D:\\C0520G1-LeToan\\Module2_LeToan\\src\\data\\booking.csv";

    public static void writeData(){
        FileManager fileManager = new FileManager();
        fileManager.writeFileBooking();
        fileManager.writeFileCustomer();
        fileManager.writeFileVilla();
        fileManager.writeFileHouse();
        fileManager.writeFileRoom();
//        fileManager.writeFileEmployee();
    }

    public static void readData(){
        FileManager fileManager = new FileManager();
        try {
            fileManager.readFileVilla();
            fileManager.readFileHouse();
            fileManager.readFileRoom();
            fileManager.readFileCustomer();
            fileManager.readFileEmployee();
        } catch (IOException e) {
            System.out.println("File not found!!!");
        }
    }

    public void writeFileVilla() {
        List<Villa> villaList = Villa.getVillaList();
        try {
            FileWriter myWrite = new FileWriter(VILLA_FILE_PATH);
            BufferedWriter bufferedWriter = new BufferedWriter(myWrite);
            for (Villa value : villaList) {
                bufferedWriter.append(String.valueOf(value.getId()));
                bufferedWriter.append(",");
                bufferedWriter.append(value.getNameServices());
                bufferedWriter.append(",");
                bufferedWriter.append(String.valueOf(value.getUsableArea()));
                bufferedWriter.append(",");
                bufferedWriter.append(String.valueOf(value.getRentCost()));
                bufferedWriter.append(",");
                bufferedWriter.append(String.valueOf(value.getMaxPerson()));
                bufferedWriter.append(",");
                bufferedWriter.append(String.valueOf(value.getRentOfType()));
                bufferedWriter.append(",");
                bufferedWriter.append(value.getRoomStandard());
                bufferedWriter.append(",");
                bufferedWriter.append(String.valueOf(value.getPoolArea()));
                bufferedWriter.append(",");
                bufferedWriter.append(String.valueOf(value.getNumberOfFloor()));
                bufferedWriter.append(",");
                bufferedWriter.append(value.getOther());
                bufferedWriter.append(",");
                Iterator includedServices = value.getIncludedServices().iterator();
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
        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        }
    }

    public void readFileVilla() throws IOException {
        List<Villa> villaList = new ArrayList<>();
        FileReader fileReader = new FileReader(VILLA_FILE_PATH);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String data;
        String[] arrayData;
        while ((data = bufferedReader.readLine()) != null) {
            Villa villa = new Villa();
            List<AvailableServices> includedServices = new ArrayList<>();
            arrayData = data.split(",");
            villa.setId(arrayData[0]);
            villa.setNameServices(arrayData[1]);
            villa.setUsableArea(Double.parseDouble(arrayData[2]));
            villa.setRentCost(Double.parseDouble(arrayData[3]));
            villa.setMaxPerson(Integer.parseInt(arrayData[4]));
            villa.setRentOfType(arrayData[5]);
            villa.setRoomStandard(arrayData[6]);
            villa.setPoolArea(Double.parseDouble(arrayData[7]));
            villa.setNumberOfFloor(Integer.parseInt(arrayData[8]));
            villa.setOther(arrayData[9]);
            for (int i = 10; i < arrayData.length; i = i + 3) {
                String name = arrayData[i];
                int unit = Integer.parseInt(arrayData[i + 1]);
                double price = Double.parseDouble(arrayData[i + 2]);
                includedServices.add(new AvailableServices(name, unit, price));
            }
            villa.setIncludedServices(includedServices);
            villaList.add(villa);
        }
        Villa.setVillaList(villaList);
        bufferedReader.close();
        fileReader.close();
    }

    public void writeFileHouse() {
        List<House> houseList = House.getHouseList();
        try {
            FileWriter fileWriter = new FileWriter(HOUSE_FILE_PATH);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (House element : houseList) {
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
                bufferedWriter.append(element.getRoomStandard());
                bufferedWriter.append(",");
                bufferedWriter.append(String.valueOf(element.getNumberOfFloor()));
                bufferedWriter.append(",");
                bufferedWriter.append(element.getOther());
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

    public void readFileHouse() throws IOException {
        List<House> houseList = new ArrayList<>();
        FileReader fileReader = new FileReader(HOUSE_FILE_PATH);
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
            houseList.add(house);
        }
        House.setHouseList(houseList);
        bufferedReader.close();
        fileReader.close();
    }

    public void writeFileRoom() {
        List<Room> roomList = Room.getRoomList();
        try {
            FileWriter myWrite = new FileWriter(ROOM_FILE_PATH);
            BufferedWriter bufferedWriter = new BufferedWriter(myWrite);
            for (Room value : roomList) {
                bufferedWriter.append(String.valueOf(value.getId()));
                bufferedWriter.append(",");
                bufferedWriter.append(value.getNameServices());
                bufferedWriter.append(",");
                bufferedWriter.append(String.valueOf(value.getUsableArea()));
                bufferedWriter.append(",");
                bufferedWriter.append(String.valueOf(value.getRentCost()));
                bufferedWriter.append(",");
                bufferedWriter.append(String.valueOf(value.getMaxPerson()));
                bufferedWriter.append(",");
                bufferedWriter.append(String.valueOf(value.getRentOfType()));
                bufferedWriter.append(",");
                bufferedWriter.append(value.getFreeServices());
                bufferedWriter.append(",");
                Iterator includedServices = value.getIncludedServices().iterator();
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

        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        }
    }

    public void readFileRoom() throws IOException {
        List<Room> roomList = new ArrayList<>();
        FileReader fileReader = new FileReader(ROOM_FILE_PATH);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String data;
        String[] arrayData;
        while ((data = bufferedReader.readLine()) != null) {
            Room room = new Room();
            List<AvailableServices> includedServices = new ArrayList<>();
            arrayData = data.split(",");
            room.setId(arrayData[0]);
            room.setNameServices(arrayData[1]);
            room.setUsableArea(Double.parseDouble(arrayData[2]));
            room.setRentCost(Double.parseDouble(arrayData[3]));
            room.setMaxPerson(Integer.parseInt(arrayData[4]));
            room.setRentOfType(arrayData[5]);
            room.setFreeServices(arrayData[6]);
            for (int i = 7; i < arrayData.length; i = i + 3) {
                String name = arrayData[i];
                int unit = Integer.parseInt(arrayData[i + 1]);
                double price = Double.parseDouble(arrayData[i + 2]);
                includedServices.add(new AvailableServices(name, unit, price));
            }
            room.setIncludedServices(includedServices);
            roomList.add(room);
        }
        Room.setRoomList(roomList);
        bufferedReader.close();
        fileReader.close();
    }

//    public void writeFileEmployee() {
//        Map<String, Employee> employeeMap = Employee.getEmployeeList();
//        try {
//            FileWriter myWrite = new FileWriter(EMPLOYEE_FILE_PATH);
//            for (Map.Entry<String, Employee> employee : employeeMap.entrySet()) {
//                myWrite.append(employee.getValue().getCodeNumber());
//                myWrite.append(",");
//                myWrite.append(employee.getValue().getName());
//                myWrite.append(",");
//                myWrite.append(String.valueOf(employee.getValue().getAge()));
//                myWrite.append(",");
//                myWrite.append(employee.getValue().getAddress());
//                myWrite.append(",");
//                myWrite.append("\n");
//            }
//            myWrite.flush();
//            myWrite.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    public void readFileEmployee() throws IOException {
        File myObj = new File(EMPLOYEE_FILE_PATH);
        Map<String, Employee> employeeList = new TreeMap<>();
        if (!myObj.exists()) {
            myObj.createNewFile();
        }
        FileReader fileReader = new FileReader(myObj);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String[] arrayData;
        String data;
        while ((data = bufferedReader.readLine()) != null) {
            arrayData = data.split(",");
            String codeNumber = arrayData[0];
            String name = arrayData[1];
            int age = Integer.parseInt(arrayData[2]);
            String address = arrayData[3];
            Employee employeeTemp = new Employee(codeNumber, name, age, address);
            employeeList.put(codeNumber, employeeTemp);
        }
        Employee.setEmployeeList(employeeList);
        bufferedReader.close();
        fileReader.close();
    }

    public void readFileCustomer() throws IOException {
        File myObj = new File(CUSTOMER_FILE_PATH);
        if (!myObj.exists()) {
            myObj.createNewFile();
        }
        List<Customer> customerList = new ArrayList<>();
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            String[] arrayData = myReader.nextLine().split(",");
            String name = arrayData[0];
            String dateOfBirth = arrayData[1];
            String gender = arrayData[2];
            String idNumber = arrayData[3];
            String phoneNumber = arrayData[4];
            String email = arrayData[5];
            String typeCustomer = arrayData[6];
            String address = arrayData[7];
            Customer customerTemp = new Customer(name, dateOfBirth, gender, idNumber, phoneNumber, email, typeCustomer, address);
            customerList.add(customerTemp);
        }
        Customer.setCustomerList(customerList);
        myReader.close();
    }

    public void writeFileCustomer() {
        List<Customer> customerList = Customer.getCustomerList();
        try {
            FileWriter myWrite = new FileWriter(CUSTOMER_FILE_PATH);
            for (Customer customer : customerList) {
                myWrite.append(customer.getName());
                myWrite.append(",");
                myWrite.append(customer.getDateOfBirth());
                myWrite.append(",");
                myWrite.append(customer.getGender());
                myWrite.append(",");
                myWrite.append(customer.getIdNumber());
                myWrite.append(",");
                myWrite.append(customer.getPhoneNumber());
                myWrite.append(",");
                myWrite.append(customer.getEmail());
                myWrite.append(",");
                myWrite.append(customer.getTypeCustomer());
                myWrite.append(",");
                myWrite.append(customer.getAddress());
                myWrite.append(",");
                myWrite.append("\n");
            }
            myWrite.flush();
            myWrite.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeFileBooking() {
        List<Customer> customerList = Customer.getCustomerList();
        try {
            FileWriter myWrite = new FileWriter(BOOKING_FILE_PATH);
            for (Customer customer : customerList) {
                if (customer.getServices() != null) {
                    myWrite.append(customer.getName());
                    myWrite.append(",");
                    myWrite.append(customer.getDateOfBirth());
                    myWrite.append(",");
                    myWrite.append(customer.getName());
                    myWrite.append(",");
                    myWrite.append(customer.getIdNumber());
                    myWrite.append(",");
                    myWrite.append(customer.getPhoneNumber());
                    myWrite.append(",");
                    myWrite.append(customer.getEmail());
                    myWrite.append(",");
                    myWrite.append(customer.getTypeCustomer());
                    myWrite.append(",");
                    myWrite.append(customer.getAddress());
                    myWrite.append(",");
                    if (customer.getServices() instanceof Villa) {
                        Villa villa = (Villa) customer.getServices();
                        myWrite.append(villa.getId());
                        myWrite.append(",");
                        myWrite.append(villa.getNameServices());
                        myWrite.append(",");
                    } else if (customer.getServices() instanceof House) {
                        House house = (House) customer.getServices();
                        myWrite.append(house.getId());
                        myWrite.append(",");
                        myWrite.append(house.getNameServices());
                        myWrite.append(",");
                    } else {
                        Room room = (Room) customer.getServices();
                        myWrite.append(room.getId());
                        myWrite.append(",");
                        myWrite.append(room.getNameServices());
                        myWrite.append(",");
                    }
                }
                myWrite.append("\n");
            }
            myWrite.flush();
            myWrite.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
