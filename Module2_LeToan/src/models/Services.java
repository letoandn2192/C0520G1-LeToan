package models;

abstract class Services {
    String nameServices;
    double usableArea;
    double rentCost;
    int maxPerson;
    String rentOfType;
    String id;
    Services.AvailableServices[] includedServices = new Services.AvailableServices[5];

    static class AvailableServices{
        String includedServices;
        int unit;
        double price;
        AvailableServices(String includedServices, int unit, double price){
            this.includedServices = includedServices;
            this.unit = unit;
            this.price = price;
        }
    }


    public abstract void showInformation();


}
