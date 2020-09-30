package vn.codegym.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Student implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotEmpty(message = "Vui lòng nhập tên")
    private String name;
    private String address;
    private int age;
    private String gender;
    private int role;

    public Student() {
    }

    public Student(String name, String address, int age, String gender, int role) {
        this.name = name;
        this.address = address;
        this.age = age;
        this.gender = gender;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Student.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Student student = (Student) target;
        if(student.getRole()!=0 && student.getRole() !=1){
            errors.rejectValue("role","role.range");
        }
        if(student.getAddress().isEmpty()){
            errors.rejectValue("address","address.notEmpty");
        } else if ("Da Nang".equals(student.getAddress())){
            errors.rejectValue("address","address.notDN");
        }
    }
}
