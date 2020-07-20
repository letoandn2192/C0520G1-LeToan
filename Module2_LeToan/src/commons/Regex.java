package commons;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Regex {
    static Scanner input = new Scanner(System.in);

/////////////////////////////////////////CHECK REGEX VILLA////////////////////////////////////////////////////////////
    public static String checkId(String id) {
        Pattern pattern = Pattern.compile("^((SVVL-|SVHO-|SVRO-)\\d{4})$");
        Matcher matcher = pattern.matcher(id);
        while (!matcher.matches()){
            System.out.println("Enter id again: ");
            id = input.nextLine();
            matcher = pattern.matcher(id);
        }
        return id;
    }

    public static String checkNameFormat(String nameFormat) {
        Pattern pattern = Pattern.compile("^[A-Z][a-z]{1,9}(([ ][A-Z][a-z]{0,9})?)*$");
        Matcher matcher = pattern.matcher(nameFormat);
       while (!matcher.matches()){
           System.out.println("Name must uppercase the first character in each word!!!");
           nameFormat = input.nextLine();
           matcher = pattern.matcher(nameFormat);
       }
        return nameFormat;
    }

    public static double checkArea(double area){
        while (area < 30.0){
            System.out.println("Area at least is 30.0 m2!!!");
            area = input.nextDouble();
        }
        return area;
    }

    public static double checkRentCost(double rentCost){
        while (rentCost <= 0){
            System.out.println("Cost must be a positive number!!!");
            rentCost = input.nextDouble();
        }
        return rentCost;
    }

    public static int checkNumber(int number){
        while (number <= 0){
            System.out.println("Input must be a positive integer!!!");
            number = input.nextInt();
        }
        return number;
    }

    public static double checkNumber(double number){
        while (number <= 0){
            System.out.println("Input must be a positive integer!!!");
            number = input.nextInt();
        }
        return number;
    }

    public static String checkRegexIncludedServices(String includedServices) {
        Pattern pattern = Pattern.compile("^(Karaoke|Massage|Food|Drink|Car)$");
        Matcher matcher = pattern.matcher(includedServices);
        while (!matcher.matches()){
            System.out.println("Services only include: Karaoke/Massage/Food/Drink/Car");
            includedServices = input.nextLine();
        }
        return includedServices;
    }

    //////////////////////////////////////////CHECK REGEX CUSTOMER/////////////////////////////////////////////////////

    public static String checkNameException(String nameCustomer) {
        Pattern pattern = Pattern.compile("^[A-Z][a-z]{1,9}(([ ][A-Z][a-z]{0,9})?)*$");
        Matcher matcher = pattern.matcher(nameCustomer);
        while (!matcher.matches()) {
            System.out.println("Customer's name must uppercase the first character in each word!!!");
            nameCustomer = input.nextLine();
            matcher = pattern.matcher(nameCustomer);
        }
        return nameCustomer;
    }

    public static String checkEmailException(String email) {
        Pattern pattern = Pattern.compile("^(\\w{3,}@\\w+\\.\\w+)$");
        Matcher matcher = pattern.matcher(email);
        while (!matcher.matches()){
            System.out.println("Email format abc.abc@abc");
            email = input.nextLine();
            matcher = pattern.matcher(email);
        }
        return email;
    }

    public static String checkGenderException(String gender) {
        gender = gender.toLowerCase();
        Pattern pattern = Pattern.compile("^(male|female|unknown)$");
        Matcher matcher = pattern.matcher(gender.toLowerCase());
        while (!matcher.matches()) {
            System.out.println("Gender include (Male/Female/Unknown): ");
            gender = input.nextLine().toLowerCase();
            matcher = pattern.matcher(gender);
        }
        if ("male".equals(gender)) {
            gender = "Male";
        } else if ("female".equals(gender)) {
            gender = "Female";
        } else {
            gender = "Unknown";
        }
        return gender;
    }

    public static String checkIdCardException(String idNumber) {
        Pattern pattern = Pattern.compile("^[0-9]{3}[ ][0-9]{3}[ ][0-9]{3}$");
        Matcher matcher = pattern.matcher(idNumber);
        while (!matcher.matches()){
            System.out.println("Enter your id number follow format XXX XXX XXX: ");
            idNumber = input.nextLine();
            matcher = pattern.matcher(idNumber);
        }
        return idNumber;
    }

    public static String checkBirthdayException(String dateOfBirth) {
        Pattern pattern = Pattern.compile("^(0[1-9]|[1-2][0-9]|[3][0-1])\\/([0][1-9]|[1][0-2])\\/(19[0-9]{2}|20[0-9]{2})$");
        Matcher matcher = pattern.matcher(dateOfBirth);
        while (!matcher.matches()){
            System.out.println("Enter your date of birth follow format DD/MM/YYYY: ");
            dateOfBirth = input.nextLine();
            matcher = pattern.matcher(dateOfBirth);
        }
        return dateOfBirth;
    }
}
