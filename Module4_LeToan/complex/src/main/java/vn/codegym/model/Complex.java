package vn.codegym.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import sun.util.calendar.BaseCalendar;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.SimpleFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Entity
public class Complex implements Validator {
    @Id
    private String complexCode;

    @ManyToOne
    @JoinColumn(name = "statusId")
    private Status complexStatus;

    private double complexArea;

    private int complexFloor;

    @ManyToOne
    @JoinColumn(name = "typeId")
    private Type complexType;

    private double complexCost;

    private String complexStartDate;

    private String complexEndDate;

    public String getComplexCode() {
        return complexCode;
    }

    public void setComplexCode(String complexCode) {
        this.complexCode = complexCode;
    }

    public Status getComplexStatus() {
        return complexStatus;
    }

    public void setComplexStatus(Status complexStatus) {
        this.complexStatus = complexStatus;
    }

    public double getComplexArea() {
        return complexArea;
    }

    public void setComplexArea(double complexArea) {
        this.complexArea = complexArea;
    }

    public int getComplexFloor() {
        return complexFloor;
    }

    public void setComplexFloor(int complexFloor) {
        this.complexFloor = complexFloor;
    }

    public Type getComplexType() {
        return complexType;
    }

    public void setComplexType(Type complexType) {
        this.complexType = complexType;
    }

    public double getComplexCost() {
        return complexCost;
    }

    public void setComplexCost(double complexCost) {
        this.complexCost = complexCost;
    }

    public String getComplexStartDate() {
        return complexStartDate;
    }

    public void setComplexStartDate(String complexStartDate) {
        this.complexStartDate = complexStartDate;
    }

    public String getComplexEndDate() {
        return complexEndDate;
    }

    public void setComplexEndDate(String complexEndDate) {
        this.complexEndDate = complexEndDate;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Complex.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Complex complex = (Complex) target;
        double cost = complex.getComplexCost();
        if (cost <= 0) {
            errors.rejectValue("complexCost", "complexCost.value");
        }
        double area = complex.getComplexArea();
        if (area <= 0) {
            errors.rejectValue("complexArea", "complexArea.value");
        }
        int floor = complex.getComplexFloor();
        if (floor <= 0) {
            errors.rejectValue("complexFloor", "complexFloor.value");
        }

        String sDate = complex.getComplexStartDate();
        String eDate = complex.getComplexEndDate();
        if (!checkValidateDate(sDate)) {
            errors.rejectValue("complexStartDate", "complexStartDate.format");
        }
        if (!checkValidateDate(eDate)) {
            errors.rejectValue("complexEndDate", "complexEndDate.format");
        }
        if (checkValidateDate(sDate) && checkValidateDate(eDate)) {
            Date startDate = null;
            Date endDate = null;
            try {
                startDate = new SimpleDateFormat("dd/MM/yyyy").parse(sDate);
                endDate = new SimpleDateFormat("dd/MM/yyyy").parse(eDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            Calendar c1 = Calendar.getInstance();
            Calendar c2 = Calendar.getInstance();
            c1.setTime(startDate);
            c2.setTime(endDate);
            c1.add(Calendar.MONTH, 6);
            if (c1.after(c2)) {
                errors.rejectValue("complexEndDate", "complexEndDate.value");
            }
        }


    }

    private boolean checkValidateDate(String input) {
        Pattern pattern = Pattern.compile("^(?=\\d{2}([-.,\\/])\\d{2}\\1\\d{4}$)(?:0[1-9]|1\\d|[2][0-8]|29(?!.02.(?!(?!(?:[02468][1-35-79]|[13579][0-13-57-9])00)\\d{2}(?:[02468][048]|[13579][26])))|30(?!.02)|31(?=.(?:0[13578]|10|12))).(?:0[1-9]|1[012]).\\d{4}$");
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
}
