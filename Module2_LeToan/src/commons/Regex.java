package commons;

import models.*;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Regex {
    private static Scanner input = new Scanner(System.in);
    public static final String REGEX_ID_VILLA = "^(SVVL-\\d{4})$";
    public static final String REGEX_ID_HOUSE = "^(SVHO-\\d{4})$";
    public static final String REGEX_ID_ROOM = "^(SVRO-\\d{4})$";
    public static final String REGEX_SERVICES_NAME = "^[A-Z][a-z]{1,9}(([ ][A-Z][a-z]{0,9})?)*$";
    public static final String REGEX_SERVICES_AREA = "^\\d+([.]?)\\d+$";
    public static final String REGEX_INTEGER= "^\\d+$";
    public static final String REGEX_DOUBLE= "^\\d+([.]\\d+)?$";
    public static final String REGEX_INCLUDED_SERVICES = "^(Karaoke|Massage|Food|Drink|Car)$";
    public static final String REGEX_NAME_CUSTOMER = "^[A-Z][a-z]{1,9}(([ ][A-Z][a-z]{0,9})?)*$";
    public static final String REGEX_EMAIL_CUSTOMER = "^(\\w{3,}@\\w+\\.\\w+)$";
    public static final String REGEX_GENDER_CUSTOMER = "^(male|female|unknown)$";
    public static final String REGEX_ID_CARD_CUSTOMER = "^[0-9]{3}[ ][0-9]{3}[ ][0-9]{3}$";
    public static final String REGEX_PHONE_NUMBER_CUSTOMER = "^\\d{9}$";
    public static final String REGEX_BIRTHDAY_CUSTOMER = "^\\d{9}$";

    public static boolean checkRegex(String regexPattern, String input){
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    /////////////////////////////////////CHECK VILLA ID///////////////////////////////////////////////////////////
    public static boolean checkDuplicateIdVilla(String id) {
        for (Services element : Villa.getVillaList()) {
            if (id.equals(element.getId())) {
                return true;
            }
        }
        return false;
    }

    public static String checkIdVilla(String id) {
        boolean isDuplicate = checkDuplicateIdVilla(id);
        while (!checkRegex(REGEX_ID_VILLA, id) || isDuplicate) {
            if (isDuplicate) {
                System.out.println("Duplicate Id!!!");
            } else {
                System.out.println("Id must be follow format!!!");
            }
            id = input.nextLine();
            isDuplicate = checkDuplicateIdVilla(id);
        }
        return id;
    }

    /////////////////////////////////////CHECK HOUSE ID///////////////////////////////////////////////////////////
    public static boolean checkDuplicateIdHouse(String id) {
        for (Services element : House.getHouseList()) {
            if (id.equals(element.getId())) {
                return true;
            }
        }
        return false;
    }

    public static String checkIdHouse(String id) {
        boolean isDuplicate = checkDuplicateIdHouse(id);
        while (!checkRegex(REGEX_ID_HOUSE, id) || isDuplicate) {
            if (isDuplicate) {
                System.out.println("Duplicate Id!!!");
            } else {
                System.out.println("Id must be follow format!!!");
            }
            id = input.nextLine();
            isDuplicate = checkDuplicateIdHouse(id);
        }
        return id;
    }

    /////////////////////////////////////CHECK HOUSE ID///////////////////////////////////////////////////////////
    public static boolean checkDuplicateIdRoom(String id) {
        for (Services element : Room.getRoomList()) {
            if (id.equals(element.getId())) {
                return true;
            }
        }
        return false;
    }

    public static String checkIdRoom(String id) {
        boolean isDuplicate = checkDuplicateIdRoom(id);
        while (!checkRegex(REGEX_ID_ROOM, id) || isDuplicate) {
            if (isDuplicate) {
                System.out.println("Duplicate Id!!!");
            } else {
                System.out.println("Id must be follow format!!!");
            }
            id = input.nextLine();
            isDuplicate = checkDuplicateIdRoom(id);
        }
        return id;
    }

    /////////////////////////////////////////CHECK REGEX SERVICES////////////////////////////////////////////////////////////
    public static String checkNameFormat(String nameFormat) {
        while (!checkRegex(REGEX_SERVICES_NAME, nameFormat)) {
            System.out.println("Name must uppercase the first character in each word!!!");
            nameFormat = input.nextLine();
        }
        return nameFormat;
    }

    public static double checkArea(String area) {
        while (!checkRegex(REGEX_SERVICES_AREA, area) || Double.parseDouble(area) < 30.0) {
            System.out.println("Area must be number and at least 30 m2!!!");
            area = input.nextLine();
        }
        return Double.parseDouble(area);
    }

    public static int checkNumberInt(String number) {
        while (!checkRegex(REGEX_INTEGER, number) || Integer.parseInt(number) <= 0) {
            System.out.println("Input must be a positive integer!!!");
            number = input.nextLine();
        }
        return Integer.parseInt(number);
    }

    public static double checkNumberDouble(String number) {
        while (!checkRegex(REGEX_DOUBLE, number) || Double.parseDouble(number) <= 0) {
            System.out.println("Input must be a positive number!!!");
            number = input.nextLine();
        }
        return Double.parseDouble(number);
    }

    public static String checkRegexIncludedServices(String includedServices) {
        while (!checkRegex(REGEX_INCLUDED_SERVICES, includedServices)) {
            System.out.println("Services only include: Karaoke/Massage/Food/Drink/Car");
            includedServices = input.nextLine();
        }
        return includedServices;
    }

    //////////////////////////////////////////CHECK REGEX CUSTOMER/////////////////////////////////////////////////////

    public static String checkNameCustomer(String nameCustomer) {
        while (!checkRegex(REGEX_NAME_CUSTOMER, nameCustomer)) {
            if (!checkRegex(REGEX_NAME_CUSTOMER, nameCustomer)) {
                try {
                    throw new NameException("Customer's name must uppercase the first character in each word!!!");
                } catch (NameException e) {
                    System.out.println(e.getMessage());
                }
                nameCustomer = input.nextLine();
            }
        }
        return nameCustomer;
    }

    public static String checkEmailCustomer(String email) {
        while (!checkRegex(REGEX_EMAIL_CUSTOMER, email)) {
            if (!checkRegex(REGEX_EMAIL_CUSTOMER, email)) {
                try {
                    throw new EmailException("Email format abc.abc@abc");
                } catch (EmailException e) {
                    System.out.println(e.getMessage());
                }
                email = input.nextLine();
            }
        }
        return email;
    }

    public static String checkGenderCustomer(String gender) {
        gender = gender.toLowerCase();
        while (!checkRegex(REGEX_GENDER_CUSTOMER, gender)) {
            if (!checkRegex(REGEX_GENDER_CUSTOMER, gender)) {
                try {
                    throw new GenderException("Gender include (Male/Female/Unknown): ");
                } catch (GenderException e) {
                    System.out.println(e.getMessage());
                }
                gender = input.nextLine().toLowerCase();
            }
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

    public static String checkIdCardCustomer(String idNumber) {
        while (!checkRegex(REGEX_ID_CARD_CUSTOMER, idNumber)) {
            if (!checkRegex(REGEX_ID_CARD_CUSTOMER, idNumber)) {
                try {
                    throw new IdCardException("Enter your id number follow format XXX XXX XXX: ");
                } catch (IdCardException e) {
                    System.out.println(e.getMessage());
                }
                idNumber = input.nextLine();
            }
        }
        return idNumber;
    }

    public static String checkPhoneNumber(String phoneNumber) {
        while (!checkRegex(REGEX_PHONE_NUMBER_CUSTOMER, phoneNumber)) {
            System.out.println("Enter your id number follow format XXXXXXXXX: ");
            phoneNumber = input.nextLine();
        }
        return phoneNumber;
    }

    public static String checkBirthdayCustomer(String dateOfBirth){
        while (!checkRegex(REGEX_BIRTHDAY_CUSTOMER, dateOfBirth)) {
            if (!checkRegex(REGEX_BIRTHDAY_CUSTOMER, dateOfBirth)) {
                try {
                    throw new BirthdayException("Enter your date of birth follow format DD/MM/YYYY: ");
                } catch (BirthdayException e) {
                    System.out.println(e.getMessage());
                }
                dateOfBirth = input.nextLine();
            }
        }
        return dateOfBirth;
    }

    //////////////////////////////CHECK BOOKING///////////////////////////////////////////////////////////////////
    public static int checkInvalidBookingCustomer(String chooseCustomer) {
        while (!checkRegex(REGEX_INTEGER, chooseCustomer) || Integer.parseInt(chooseCustomer) - 1 >= Customer.getCustomerList().size() || Integer.parseInt(chooseCustomer) - 1 < 0) {
            System.out.println("Invalid Value!!!. Choose again!!!");
            chooseCustomer = input.nextLine();
        }
        return Integer.parseInt(chooseCustomer);
    }

    public static int checkInvalidBookingVilla(String chooseVilla) {
        while (!checkRegex(REGEX_INTEGER, chooseVilla) || Integer.parseInt(chooseVilla) - 1 >= Villa.getVillaList().size() || Integer.parseInt(chooseVilla) - 1 < 0) {
            System.out.println("Invalid Value!!!. Choose again!!!");
            chooseVilla = input.nextLine();
        }
        return Integer.parseInt(chooseVilla);
    }

    public static int checkInvalidBookingHouse(String chooseHouse) {
        while (!checkRegex(REGEX_INTEGER, chooseHouse) || Integer.parseInt(chooseHouse) - 1 >= House.getHouseList().size() || Integer.parseInt(chooseHouse) - 1 < 0) {
            System.out.println("Invalid Value!!!. Choose again!!!");
            chooseHouse = input.nextLine();
        }
        return Integer.parseInt(chooseHouse);
    }

    public static int checkInvalidBookingRoom(String chooseRoom) {
        while (!checkRegex(REGEX_INTEGER, chooseRoom) || Integer.parseInt(chooseRoom) - 1 >= Room.getRoomList().size() || Integer.parseInt(chooseRoom) - 1 < 0) {
            System.out.println("Invalid Value!!!. Choose again!!!");
            chooseRoom = input.nextLine();
        }
        return Integer.parseInt(chooseRoom);
    }
}
