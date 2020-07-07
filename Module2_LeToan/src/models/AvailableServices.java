package models;

public class AvailableServices {
    String includedServices;
    int unit;
    double price;
    public AvailableServices(String includedServices, int unit, double price){
        this.includedServices = includedServices;
        this.unit = unit;
        this.price = price;
    }
}
