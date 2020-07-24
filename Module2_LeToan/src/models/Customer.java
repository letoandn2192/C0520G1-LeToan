package models;

import commons.Regex;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Customer implements Comparable<Customer> {
    private String name;
    private String dateOfBirth;
    private String gender;
    private String idNumber;
    private String phoneNumber;
    private String email;
    private String typeCustomer;
    private String address;
    private Services services;
    private static List<Customer> customers = new ArrayList<>();
    private static Scanner input = new Scanner(System.in);
    private static final String FILE_PATH = "D:\\C0520G1-LeToan\\Module2_LeToan\\data\\customer.csv";

    public Customer() {
    }

    public Customer(String name, String dateOfBirth, String gender, String idNumber, String phoneNumber, String email, String typeCustomer, String address) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.idNumber = idNumber;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.typeCustomer = typeCustomer;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setServices(Services services) {
        this.services = services;
    }

    public Services getServices() {
        return services;
    }

    public static List<Customer> getCustomers() {
        return customers;
    }

    public String getYear(String dateOfBirth){
        String[] array = dateOfBirth.split("/");
        return array[2];
    }

    public static void showInformation() throws IOException {
        readFileCustomer();
        Collections.sort(customers);
        System.out.printf("%-4s%-30s%-20s%-15s%-15s%-20s%-30s%-20s%-20s", "", "Name", "Date of birth", "Gender", "Id Number", "Phone Number", "Email", "Type Of Customer", "Address");
        System.out.println();
        int order = 0;
        for (Customer customer : customers) {
            System.out.printf("%-4s%-30s%-20s%-15s%-15s%-20s%-30s%-20s%-20s", ++order + ".", customer.name, customer.dateOfBirth, customer.gender, customer.idNumber,
                    customer.phoneNumber, customer.email, customer.typeCustomer, customer.address);
            System.out.println();
        }
    }

    public static void addNewCustomer() throws IOException {
        String name, dateOfBirth,idNumber, gender, phoneNumber, email, typeCustomer, address;
        Services services;
        System.out.println("Enter your name: ");
        name = Regex.checkNameException(input.nextLine());
        System.out.println("Enter your date of birth: ");
        dateOfBirth = Regex.checkBirthdayException(input.nextLine());
        System.out.println("Enter your gender: ");
        gender = Regex.checkGenderException(input.nextLine());
        System.out.println("Enter your id number: ");
        idNumber = Regex.checkIdCardException(input.nextLine());
        System.out.println("Enter your phone number: ");
        phoneNumber = input.nextLine();
        System.out.println("Enter your email: ");
        email = Regex.checkEmailException(input.nextLine());
        System.out.println("Enter your type of customer (Diamond/Platinum/Gold/Silver/Member): ");
        typeCustomer = input.nextLine();
        System.out.println("Enter your address: ");
        address = input.nextLine();
        customers.add(new Customer(name, dateOfBirth, gender, idNumber, phoneNumber, email, typeCustomer, address));
        writeFileCustomer();
    }

    public static void readFileCustomer() throws IOException {
        File myObj = new File(FILE_PATH);
        if(!myObj.exists()){
            myObj.createNewFile();
        }
        Scanner myReader = new Scanner(myObj);
        customers.clear();
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
            customers.add(customerTemp);
        }
        myReader.close();
    }

    public static void writeFileCustomer() throws IOException{
        FileWriter myWrite = new FileWriter(FILE_PATH);
        for (Customer customer : customers) {
            myWrite.append(customer.name);
            myWrite.append(",");
            myWrite.append(customer.dateOfBirth);
            myWrite.append(",");
            myWrite.append(customer.gender);
            myWrite.append(",");
            myWrite.append(customer.idNumber);
            myWrite.append(",");
            myWrite.append(customer.phoneNumber);
            myWrite.append(",");
            myWrite.append(customer.email);
            myWrite.append(",");
            myWrite.append(customer.typeCustomer);
            myWrite.append(",");
            myWrite.append(customer.address);
            myWrite.append(",");
            if(customer.services != null){
            myWrite.append(customer.services.getId());
            myWrite.append(",");
            myWrite.append(customer.services.getNameServices());
            myWrite.append(",");
            }
            myWrite.append("\n");
        }
        System.out.println("CSV file was created successfully !!!");
        myWrite.flush();
        myWrite.close();
    }

    @Override
    public int compareTo(Customer o) {
        if(this.name.compareTo(o.getName()) > 0){
            return 1;
        }else if(this.name.compareTo(o.getName()) < 0){
            return -1;
        }else {
            return this.getYear(this.dateOfBirth).compareTo(o.getYear(o.getDateOfBirth()));
        }
    }
}
