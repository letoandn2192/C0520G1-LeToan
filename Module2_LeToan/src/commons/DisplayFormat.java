package commons;

public class DisplayFormat {
    public static String villaTitle() {
        return String.format("%-4s%-12s%-30s%-20s%-10s%-10s%-10s%-10s%-15s%-10s%-10s%s", "", "Id",
                "Name", "Villa's Area", "Cost", "Capacity", "Type", "Standard", "Pool's Area", "Floor", "Other", "Included Services");
    }

    public static String houseTitle() {
        return String.format("%-4s%-12s%-30s%-20s%-10s%-10s%-10s%-10s%-8s%-10s%s", "", "Id",
                "Name", "Villa's Area", "Cost", "Capacity", "Type", "Standard", "Floor", "Other", "Included Services");
    }
    public static String roomTitle() {
        return String.format("%-4s%-12s%-30s%-20s%-10s%-10s%-10s%-15s%s", "", "Id",
                "Name", "Villa's Area", "Cost", "Capacity", "Type", "Free Services", "Included Services");
    }

    public static String customerTitle(){
        return String.format("%-4s%-30s%-20s%-15s%-15s%-20s%-30s%-20s%-20s", "", "Name", "Date of birth", "Gender",
                "Id Number", "Phone Number", "Email", "Type Of Customer", "Address");
    }

    public static String mainMenu(){
        return  "*************************MENU*****************************" + "\n" +
                "*              1. Add New Services.                      *" + "\n" +
                "*              2. Show Services.                         *" + "\n" +
                "*              3. Add New Customer.                      *" + "\n" +
                "*              4. Show Information of Customer.          *" + "\n" +
                "*              5. Add New Booking.                       *" + "\n" +
                "*              6. Show Information of Employee.          *" + "\n" +
                "*              7. Other Convenient.                      *" + "\n" +
                "*              8. Exit.                                  *" + "\n" +
                "**********************************************************";
    }

    public static String addServicesMenu(){
        return  "1. Add New Villa." + "\n" +
                "2. Add New House." + "\n" +
                "3. Add New Room." + "\n" +
                "4. Back to Menu." + "\n" +
                "5. Exit.";
    }

    public static String showServicesMenu(){
        return  "1. Show all Villa." + "\n" +
                "2. Show all House." + "\n" +
                "3. Show all Room." + "\n" +
                "4. Show all Villa Not Duplicate." + "\n" +
                "5. Show all House Not Duplicate." + "\n" +
                "6. Show all Room Not Duplicate." + "\n" +
                "7. Back to Menu." + "\n" +
                "8. Exit.";
    }

    public static String bookingMenu(){
        return  "1. Booking Villa" + "\n" +
                "2. Booking House" + "\n" +
                "3. Booking Room" + "\n" +
                "4. Back to Menu";
    }

    public static String otherMenu(){
        return  "1. Movie theater" + "\n" +
                "2. Cabinet";
    }
}
