package models;

import java.util.*;

public class Employee{
    private String codeNumber;
    private String name;
    private int age;
    private String address;
    private static Map<String, Employee> employeeList = new TreeMap<>();

    public Employee(String codeNumber, String name, int age, String address) {
        this.codeNumber = codeNumber;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public static void setEmployeeList(Map<String, Employee> employees) {
        Employee.employeeList = employees;
    }

    public String getCodeNumber() {
        return codeNumber;
    }

    @Override
    public String toString() {
        return String.format("%-5s%-20s%-5d%s", this.codeNumber, this.name, this.age, this.address);
    }

    public static void showInformation(){
        System.out.printf("%-5s%-20s%-5s%s", "Code", "Name", "Age", "Address");
        System.out.println();
        for(Map.Entry<String, Employee> entry: employeeList.entrySet()){
            System.out.println(entry.getValue());
        }
    }
}
