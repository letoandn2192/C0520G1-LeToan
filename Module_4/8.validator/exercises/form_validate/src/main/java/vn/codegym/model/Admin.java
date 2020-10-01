package vn.codegym.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;

@Entity
@Table
public class Admin implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int adminId;
    private String adminFirstName;
    private String adminLastName;
    private int adminAge;
    private String adminPhoneNumber;
    private String adminEmail;

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getAdminFirstName() {
        return adminFirstName;
    }

    public void setAdminFirstName(String adminFirstName) {
        this.adminFirstName = adminFirstName;
    }

    public String getAdminLastName() {
        return adminLastName;
    }

    public void setAdminLastName(String adminLastName) {
        this.adminLastName = adminLastName;
    }

    public int getAdminAge() {
        return adminAge;
    }

    public void setAdminAge(int adminAge) {
        this.adminAge = adminAge;
    }

    public String getAdminPhoneNumber() {
        return adminPhoneNumber;
    }

    public void setAdminPhoneNumber(String adminPhoneNumber) {
        this.adminPhoneNumber = adminPhoneNumber;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Admin.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Admin admin = (Admin) target;
        String firstName = admin.getAdminFirstName();
        if (firstName.length() < 5 || firstName.length() > 45 ) {
            errors.rejectValue("adminFirstName", "adminFirstName.length");
        }
        String lastName = admin.getAdminLastName();
        if (lastName.length() < 5 || lastName.length() > 45) {
            errors.rejectValue("adminLastName", "adminLastName.length");
        }
        int age = admin.getAdminAge();
        if (age < 18) {
            errors.rejectValue("adminAge", "adminAge.age");
//            errors.rejectValue("adminAge", "typeMismatch.admin.adminAge");
        }
        String phoneNumber = admin.getAdminPhoneNumber();
        if (!phoneNumber.matches("^(090|091|\\\\(84\\\\)\\\\+90|\\\\(84\\\\)\\\\+91)\\\\d{7}$")) {
            errors.rejectValue("adminPhoneNumber", "adminPhoneNumber.length");
        }
        String email = admin.getAdminEmail();
        if (!email.matches("^(\\w{3,}@\\w+\\.\\w+)$")) {
            errors.rejectValue("adminEmail", "admin.email");
        }
    }
}
