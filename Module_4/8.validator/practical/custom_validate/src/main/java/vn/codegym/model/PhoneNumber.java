package vn.codegym.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;

@Entity
@Table
public class PhoneNumber implements Validator {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String number;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return PhoneNumber.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        PhoneNumber phoneNumber = (PhoneNumber) target;
        if(phoneNumber.getNumber().length() > 11 || phoneNumber.getNumber().length() < 10) {
            errors.rejectValue("number", "number.length");
        }
        if (phoneNumber.getNumber().startsWith("0")) {
            errors.rejectValue("number", "number.startWith");
        }
        if (!phoneNumber.getNumber().matches("(^$|[0-9]*$)")) {
            errors.rejectValue("number", "number.matches");
        }
    }
}
