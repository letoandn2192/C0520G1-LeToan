package model;

import java.sql.Date;

public class Employee {
    private String employeeId;
    private String employeeName;
    private String employeeBirthday;
    private String employeeIdCard;
    private double employeeSalary;
    private String employeePhone;
    private String employeeEmail;
    private String employeeAddress;
    private int positionId;
    private int educationDegreeId;
    private int divisionId;
    private String userName;

    public Employee() {
    }

    public Employee(String employee_name, String employee_birthday, String employee_id_card, double employee_salary, String employee_phone, String employee_email, String employee_address, int position_id, int education_degree_id, int division_id, String username) {
        this.employeeName = employee_name;
        this.employeeBirthday = employee_birthday;
        this.employeeIdCard = employee_id_card;
        this.employeeSalary = employee_salary;
        this.employeePhone = employee_phone;
        this.employeeEmail = employee_email;
        this.employeeAddress = employee_address;
        this.positionId = position_id;
        this.educationDegreeId = education_degree_id;
        this.divisionId = division_id;
        this.userName = username;
    }

    public Employee(String employee_id, String employee_name, String employee_birthday, String employee_id_card, double employee_salary, String employee_phone, String employee_email, String employee_address, int position_id, int education_degree_id, int division_id, String username) {
        this.employeeId = employee_id;
        this.employeeName = employee_name;
        this.employeeBirthday = employee_birthday;
        this.employeeIdCard = employee_id_card;
        this.employeeSalary = employee_salary;
        this.employeePhone = employee_phone;
        this.employeeEmail = employee_email;
        this.employeeAddress = employee_address;
        this.positionId = position_id;
        this.educationDegreeId = education_degree_id;
        this.divisionId = division_id;
        this.userName = username;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employee_id) {
        this.employeeId = employee_id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeBirthday() {
        return employeeBirthday;
    }

    public void setEmployeeBirthday(String employeeBirthday) {
        this.employeeBirthday = employeeBirthday;
    }

    public String getEmployeeIdCard() {
        return employeeIdCard;
    }

    public void setEmployeeIdCard(String employeeIdCard) {
        this.employeeIdCard = employeeIdCard;
    }

    public double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public int getEducationDegreeId() {
        return educationDegreeId;
    }

    public void setEducationDegreeId(int educationDegreeId) {
        this.educationDegreeId = educationDegreeId;
    }

    public int getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(int divisionId) {
        this.divisionId = divisionId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
