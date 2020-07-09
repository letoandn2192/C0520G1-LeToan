package models;

public class AvailableServices {
    String includedServicesName;
    int unit;
    double price;
    public AvailableServices(String includedServicesName, int unit, double price){
        this.includedServicesName = includedServicesName;
        this.unit = unit;
        this.price = price;
    }
}
