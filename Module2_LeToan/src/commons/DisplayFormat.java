package commons;

public class StringFormat {
    public static String printVillaTitle(){
        return String.format("%-4s%-12s%-30s%-20s%-10s%-10s%-10s%-10s%-15s%-10s%-10s%s", "", "Id",
                "Name", "Villa's Area", "Cost", "Capacity", "Type", "Standard", "Pool's Area", "Floor", "Other", "Included Services");
    }
}
