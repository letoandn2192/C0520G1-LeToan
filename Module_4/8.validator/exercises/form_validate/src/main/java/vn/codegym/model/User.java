package vn.codegym.model;

import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    @NotEmpty
    @Size(min = 5, max = 45, message = "Length between 5 to 45")
    private String userFirstName;

    @NotEmpty
    @Size(min = 5, max = 45, message = "Length between 5 to 45")
    private String userLastName;

    @Min(value = 18, message = "Age at least 18")
    private int userAge;

    @NotEmpty
    @Size(min = 10, max = 11, message = "Length between 10 to 11")
    @Pattern(regexp = "(^$|[0-9]*$)", message = "Phone Number must be integer")
    private String userPhoneNumber;

    @Pattern(regexp = "^(\\w{3,}@\\w+\\.\\w+)$", message = "Email format abc@abc.abc")
    private String userEmail;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userSecondName) {
        this.userLastName = userSecondName;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
