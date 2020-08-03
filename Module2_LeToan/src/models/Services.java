package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Services{
    private String nameServices;
    private double usableArea;
    private double rentCost;
    private int maxPerson;
    private String rentOfType;
    private String id;
    private List<AvailableServices> includedServices = new ArrayList<>();

    public Services(){
    }

    public Services(String id, String nameServices, double usableArea, double rentCost, int maxPerson, String rentOfType) {
        this.id = id;
        this.nameServices = nameServices;
        this.usableArea = usableArea;
        this.rentCost = rentCost;
        this.maxPerson = maxPerson;
        this.rentOfType = rentOfType;
    }

    public List<AvailableServices> getIncludedServices() {
        Collections.sort(this.includedServices);
        return this.includedServices;
    }

    public void setIncludedServices(List<AvailableServices> includedServices) {
        this.includedServices = includedServices;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameServices() {
        return nameServices;
    }

    public void setNameServices(String nameServices) {
        this.nameServices = nameServices;
    }

    public double getUsableArea() {
        return usableArea;
    }

    public void setUsableArea(double usableArea) {
        this.usableArea = usableArea;
    }

    public double getRentCost() {
        return rentCost;
    }

    public void setRentCost(double rentCost) {
        this.rentCost = rentCost;
    }

    public int getMaxPerson() {
        return maxPerson;
    }

    public void setMaxPerson(int maxPerson) {
        this.maxPerson = maxPerson;
    }

    public String getRentOfType() {
        return rentOfType;
    }

    public void setRentOfType(String rentOfType) {
        this.rentOfType = rentOfType;
    }

    public abstract void showInformation();

}
