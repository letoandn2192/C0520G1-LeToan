package models;

abstract class Services {
    String nameServices;
    double usableArea;
    double rentCost;
    int maxPerson;
    String rentOfType;
    String id;
    AvailableServices[] includedServices = new AvailableServices[5];

    public AvailableServices[] getIncludedServices() {
        return includedServices;
    }

    public void setIncludedServices(AvailableServices[] includedServices) {
        this.includedServices = includedServices;
    }

    public abstract void showInformation();

}
