package models;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.*;

public class Employee {
    private String codeNumber;
    private String name;
    private int age;
    private String address;
    private static Map<String, Employee> employees = new TreeMap<>();

    public Employee(String codeNumber, String name, int age, String address) {
        this.codeNumber = codeNumber;
        this.name = name;
        this.age = age;
        this.address = address;
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
        for(Map.Entry<String, Employee> entry: employees.entrySet()){
            System.out.println(entry.getValue());
        }
    }

    public static void readFileEmployee() throws FileNotFoundException {
        File myObj = new File("D:\\C0520G1-LeToan\\Module2_LeToan\\data\\employee.csv");
        Scanner myReader = new Scanner(myObj);
        employees.clear();
        while (myReader.hasNextLine()) {
            String[] arrayData = myReader.nextLine().split(",");
            String codeNumber = arrayData[0];
            String name = arrayData[1];
            int age = Integer.parseInt(arrayData[2]);
            String address = arrayData[3];
            Employee employeeTemp = new Employee(codeNumber, name, age, address);
            employees.put(employeeTemp.getCodeNumber(), employeeTemp);
        }
        myReader.close();
    }
}
