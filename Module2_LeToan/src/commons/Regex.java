package commons;

import models.*;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Regex {
    static Scanner input = new Scanner(System.in);

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
        Pattern pattern = Pattern.compile("^(SVVL-\\d{4})$");
        Matcher matcher = pattern.matcher(id);
        boolean isDuplicate = checkDuplicateIdVilla(id);
        while (!matcher.matches() || isDuplicate) {
            if (isDuplicate) {
                System.out.println("Duplicate Id!!!");
            } else {
                System.out.println("Id must be follow format!!!");
            }
            id = input.nextLine();
            matcher = pattern.matcher(id);
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
        Pattern pattern = Pattern.compile("^(SVHO-\\d{4})$");
        Matcher matcher = pattern.matcher(id);
        boolean isDuplicate = checkDuplicateIdHouse(id);
        while (!matcher.matches() || isDuplicate) {
            if (isDuplicate) {
                System.out.println("Duplicate Id!!!");
            } else {
                System.out.println("Id must be follow format!!!");
            }
            id = input.nextLine();
            matcher = pattern.matcher(id);
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
        Pattern pattern = Pattern.compile("^(SVRO-\\d{4})$");
        Matcher matcher = pattern.matcher(id);
        boolean isDuplicate = checkDuplicateIdRoom(id);
        while (!matcher.matches() || isDuplicate) {
            if (isDuplicate) {
                System.out.println("Duplicate Id!!!");
            } else {
                System.out.println("Id must be follow format!!!");
            }
            id = input.nextLine();
            matcher = pattern.matcher(id);
            isDuplicate = checkDuplicateIdRoom(id);
        }
        return id;
    }

    /////////////////////////////////////////CHECK REGEX SERVICES////////////////////////////////////////////////////////////
    public static String checkNameFormat(String nameFormat) {
        Pattern pattern = Pattern.compile("^[A-Z][a-z]{1,9}(([ ][A-Z][a-z]{0,9})?)*$");
        Matcher matcher = pattern.matcher(nameFormat);
        while (!matcher.matches()) {
            System.out.println("Name must uppercase the first character in each word!!!");
            nameFormat = input.nextLine();
            matcher = pattern.matcher(nameFormat);
        }
        return nameFormat;
    }

    public static double checkArea(String area) {
        Pattern pattern = Pattern.compile("^\\d+([.]?)\\d+$");
        Matcher matcher = pattern.matcher(area);
        while (!matcher.matches() || Double.parseDouble(area) < 30.0) {
            System.out.println("Area must be number and at least 30 m2!!!");
            area = input.nextLine();
            matcher = pattern.matcher(area);
        }
        return Double.parseDouble(area);
    }

    public static int checkNumberInt(String number) {
        Pattern pattern = Pattern.compile("^\\d+$");
        Matcher matcher = pattern.matcher(number);
        while (!matcher.matches() || Integer.parseInt(number) <= 0) {
            System.out.println("Input must be a positive integer!!!");
            number = input.nextLine();
            matcher = pattern.matcher(number);
        }
        return Integer.parseInt(number);
    }

    public static double checkNumberDouble(String number) {
        Pattern pattern = Pattern.compile("^\\d+([.]\\d+)?$");
        Matcher matcher = pattern.matcher(number);
        while (!matcher.matches() || Double.parseDouble(number) <= 0) {
            System.out.println("Input must be a positive number!!!");
            number = input.nextLine();
            matcher = pattern.matcher(number);
        }
        return Double.parseDouble(number);
    }

    public static String checkRegexIncludedServices(String includedServices) {
        Pattern pattern = Pattern.compile("^(Karaoke|Massage|Food|Drink|Car)$");
        Matcher matcher = pattern.matcher(includedServices);
        while (!matcher.matches()) {
            System.out.println("Services only include: Karaoke/Massage/Food/Drink/Car");
            includedServices = input.nextLine();
            matcher = pattern.matcher(includedServices);
        }
        return includedServices;
    }

    //////////////////////////////////////////CHECK REGEX CUSTOMER/////////////////////////////////////////////////////

    public static String checkNameCustomer(String nameCustomer) {
        Pattern pattern = Pattern.compile("^[A-Z][a-z]{1,9}(([ ][A-Z][a-z]{0,9})?)*$");
        Matcher matcher = pattern.matcher(nameCustomer);
        do {
            if (!matcher.matches()) {
                try {
                    throw new NameException("Customer's name must uppercase the first character in each word!!!");
                } catch (NameException e) {
                    System.out.println(e.getMessage());
                }
                nameCustomer = input.nextLine();
                matcher = pattern.matcher(nameCustomer);
            }
        } while (!matcher.matches());
        return nameCustomer;
    }

    public static String checkEmailCustomer(String email) {
        Pattern pattern = Pattern.compile("^(\\w{3,}@\\w+\\.\\w+)$");
        Matcher matcher = pattern.matcher(email);
        do {
            if (!matcher.matches()) {
                try {
                    throw new EmailException("Email format abc.abc@abc");
                } catch (EmailException e) {
                    System.out.println(e.getMessage());
                }
                email = input.nextLine();
                matcher = pattern.matcher(email);
            }
        } while (!matcher.matches());
        return email;
    }

    public static String checkGenderCustomer(String gender) {
        gender = gender.toLowerCase();
        Pattern pattern = Pattern.compile("^(male|female|unknown)$");
        Matcher matcher = pattern.matcher(gender.toLowerCase());
        do {
            if (!matcher.matches()) {
                try {
                    throw new GenderException("Gender include (Male/Female/Unknown): ");
                } catch (GenderException e) {
                    System.out.println(e.getMessage());
                }
                gender = input.nextLine().toLowerCase();
                matcher = pattern.matcher(gender);
            }
        } while (!matcher.matches());
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
        Pattern pattern = Pattern.compile("^[0-9]{3}[ ][0-9]{3}[ ][0-9]{3}$");
        Matcher matcher = pattern.matcher(idNumber);
        do {
            if (!matcher.matches()) {
                try {
                    throw new IdCardException("Enter your id number follow format XXX XXX XXX: ");
                } catch (IdCardException e) {
                    System.out.println(e.getMessage());
                }
                idNumber = input.nextLine();
                matcher = pattern.matcher(idNumber);
            }
        } while (!matcher.matches());
        return idNumber;
    }

    public static String checkPhoneNumber(String phoneNumber) {
        Pattern pattern = Pattern.compile("^\\d{9}$");
        Matcher matcher = pattern.matcher(phoneNumber);
        while (!matcher.matches()) {
            System.out.println("Enter your id number follow format XXXXXXXXX: ");
            phoneNumber = input.nextLine();
            matcher = pattern.matcher(phoneNumber);
        }
        return phoneNumber;
    }

    public static String checkBirthdayCustomer(String dateOfBirth) {
        Pattern pattern = Pattern.compile("^(0[1-9]|[1-2][0-9]|[3][0-1])\\/([0][1-9]|[1][0-2])\\/(19[0-9]{2}|20[0-9]{2})$");
        Matcher matcher = pattern.matcher(dateOfBirth);
        do {
            if (!matcher.matches()) {
                try {
                    throw new BirthdayException("Enter your date of birth follow format DD/MM/YYYY: ");
                } catch (BirthdayException e) {
                    System.out.println(e.getMessage());
                }
                dateOfBirth = input.nextLine();
                matcher = pattern.matcher(dateOfBirth);
            }
        } while (!matcher.matches());
        return dateOfBirth;
    }

    //////////////////////////////CHECK BOOKING///////////////////////////////////////////////////////////////////
    public static int checkInvalidBookingCustomer(String chooseCustomer) {
        Pattern pattern = Pattern.compile("^\\d+$");
        Matcher matcher = pattern.matcher(chooseCustomer);
        while (!matcher.matches() || Integer.parseInt(chooseCustomer) - 1 >= Customer.getCustomerList().size() || Integer.parseInt(chooseCustomer) - 1 < 0) {
            System.out.println("Invalid Value!!!. Choose again!!!");
            chooseCustomer = input.nextLine();
            matcher = pattern.matcher(chooseCustomer);
        }
        return Integer.parseInt(chooseCustomer);
    }

    public static int checkInvalidBookingVilla(String chooseVilla) {
        Pattern pattern = Pattern.compile("^\\d+$");
        Matcher matcher = pattern.matcher(chooseVilla);
        while (!matcher.matches() || Integer.parseInt(chooseVilla) - 1 >= Villa.getVillaList().size() || Integer.parseInt(chooseVilla) - 1 < 0) {
            System.out.println("Invalid Value!!!. Choose again!!!");
            chooseVilla = input.nextLine();
            matcher = pattern.matcher(chooseVilla);
        }
        return Integer.parseInt(chooseVilla);
    }

    public static int checkInvalidBookingHouse(String chooseHouse) {
        Pattern pattern = Pattern.compile("^\\d+$");
        Matcher matcher = pattern.matcher(chooseHouse);
        while (!matcher.matches() || Integer.parseInt(chooseHouse) - 1 >= House.getHouseList().size() || Integer.parseInt(chooseHouse) - 1 < 0) {
            System.out.println("Invalid Value!!!. Choose again!!!");
            chooseHouse = input.nextLine();
            matcher = pattern.matcher(chooseHouse);
        }
        return Integer.parseInt(chooseHouse);
    }

    public static int checkInvalidBookingRoom(String chooseRoom) {
        Pattern pattern = Pattern.compile("^\\d+$");
        Matcher matcher = pattern.matcher(chooseRoom);
        while (!matcher.matches() || Integer.parseInt(chooseRoom) - 1 >= Room.getRoomList().size() || Integer.parseInt(chooseRoom) - 1 < 0) {
            System.out.println("Invalid Value!!!. Choose again!!!");
            chooseRoom = input.nextLine();
            matcher = pattern.matcher(chooseRoom);
        }
        return Integer.parseInt(chooseRoom);
    }
}
