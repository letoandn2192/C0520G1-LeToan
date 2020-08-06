package models;

import java.util.Stack;

public class Cabinet {
    private Stack<Employee> cabinet = new Stack<>();

    public Cabinet() {
        Employee.getEmployeeList();
        for (Employee employee : Employee.getEmployeeList().values()) {
            this.cabinet.add(employee);
        }
    }

    public void search(Employee employee) {
        if (cabinet.search(employee) != -1) {
            System.out.println("Found it !!!");
        } else {
            System.out.println("No Found!!!");
        }
    }
}
