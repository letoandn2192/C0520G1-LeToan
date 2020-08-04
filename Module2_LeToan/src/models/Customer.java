package models;

import commons.Regex;

import java.util.*;

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
    private static List<Customer> customerList = new ArrayList<>();
    private static Scanner input = new Scanner(System.in);

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

    public String getGender() {
        return gender;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getTypeCustomer() {
        return typeCustomer;
    }

    public String getAddress() {
        return address;
    }

    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }

    public static List<Customer> getCustomerList() {
        return customerList;
    }

    public static void setCustomerList(List<Customer> customerList) {
        Customer.customerList = customerList;
    }

    public String getYear(String dateOfBirth){
        String[] array = dateOfBirth.split("/");
        return array[2];
    }

    public static void showInformation() {
        Collections.sort(customerList);
        System.out.printf("%-4s%-30s%-20s%-15s%-15s%-20s%-30s%-20s%-20s", "", "Name", "Date of birth", "Gender", "Id Number", "Phone Number", "Email", "Type Of Customer", "Address");
        System.out.println();
        int order = 0;
        for (Customer customer : customerList) {
            System.out.printf("%-4s%-30s%-20s%-15s%-15s%-20s%-30s%-20s%-20s", ++order + ".", customer.name, customer.dateOfBirth, customer.gender, customer.idNumber,
                    customer.phoneNumber, customer.email, customer.typeCustomer, customer.address);
            System.out.println();
        }
    }

    public static void addNewCustomer() {
        String name, dateOfBirth,idNumber, gender, phoneNumber, email, typeCustomer, address;
        System.out.println("Enter your name: ");
        name = Regex.checkNameCustomer(input.nextLine());
        System.out.println("Enter your date of birth: ");
        dateOfBirth = Regex.checkBirthdayCustomer(input.nextLine());
        System.out.println("Enter your gender: ");
        gender = Regex.checkGenderCustomer(input.nextLine());
        System.out.println("Enter your id number: ");
        idNumber = Regex.checkIdCardCustomer(input.nextLine());
        System.out.println("Enter your phone number: ");
        phoneNumber = Regex.checkPhoneNumber(input.nextLine());
        System.out.println("Enter your email: ");
        email = Regex.checkEmailCustomer(input.nextLine());
        System.out.println("Enter your type of customer (Diamond/Platinum/Gold/Silver/Member): ");
        typeCustomer = input.nextLine();
        System.out.println("Enter your address: ");
        address = input.nextLine();
        customerList.add(new Customer(name, dateOfBirth, gender, idNumber, phoneNumber, email, typeCustomer, address));
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

    @Override
    public String toString() {
        return this.name;
    }
}
