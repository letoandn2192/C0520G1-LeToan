package vn.codegym.model;

import com.fasterxml.jackson.annotation.*;
import vn.codegym.common.validate_birthday.ValidateBirthdayGreater18;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import java.util.Set;

@Entity
@Table
public class Employee {
    public interface IdCheck {};
    public interface EditCheck {};

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long employeeId;

    @NotEmpty(message = "Name not be empty!!!", groups = EditCheck.class)
    private String employeeName;

    @ValidateBirthdayGreater18(groups = EditCheck.class)
    private String employeeBirthday;

    @Pattern(regexp = "^((\\d{9})|(\\d{12}))$", message = "Id card format is XXXXXXXXX or XXXXXXXXXXXX", groups = EditCheck.class)
    private String employeeIdCard;

    @Positive(message = "Salary must be positive", groups = EditCheck.class)
    private double employeeSalary;

    @Pattern(regexp = "^(090|091|\\(84\\)\\+90|\\(84\\)\\+91)\\d{7}$", message = "Format is 090xxxxxxx, 091xxxxxxx, (84)+90xxxxxxx, (84)+91xxxxxxx", groups = EditCheck.class)
    private String employeePhone;

    @Pattern(regexp = "^(\\w{3,}@\\w+\\.\\w+)$", message = "Email follow format abc@abc.abc", groups = EditCheck.class)
    private String employeeEmail;

    @NotEmpty(message = "Address not be empty!!!", groups = EditCheck.class)
    private String employeeAddress;

    @ManyToOne
    @JoinColumn(name = "divisionId")
    @JsonIgnoreProperties("employees")
    private Division division;

    @ManyToOne
    @JoinColumn(name = "positionId")
    @JsonIgnoreProperties("employees")
    private Position position;

    @ManyToOne
    @JoinColumn(name = "educationDegreeId")
    @JsonIgnoreProperties("employees")
    private EducationDegree educationDegree;

    @ManyToOne
    @JoinColumn(name = "userName")
    @JsonIgnore
    private User user;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("employee")
    private Set<Contract> contracts;

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
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

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
