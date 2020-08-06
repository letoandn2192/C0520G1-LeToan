package models;

import java.io.Serializable;

public class AvailableServices implements Comparable<AvailableServices>, Serializable {
    private String includedServicesName;
    private int unit;
    private double price;

    public AvailableServices(String includedServicesName, int unit, double price) {
        this.includedServicesName = includedServicesName;
        this.unit = unit;
        this.price = price;
    }

    public String getIncludedServicesName() {
        return includedServicesName;
    }

    public int getUnit() {
        return unit;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public int compareTo(AvailableServices o) {
        return this.includedServicesName.compareTo(o.getIncludedServicesName());
    }

    @Override
    public String toString() {
        return  this.includedServicesName + "/" +
                 + this.unit + "/" + this.price;
    }
}
