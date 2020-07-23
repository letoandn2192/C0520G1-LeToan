package models;

import java.io.Serializable;

public class AvailableServices implements Comparable<AvailableServices>, Serializable {
    String includedServicesName;
    int unit;
    double price;

    public AvailableServices(String includedServicesName, int unit, double price) {
        this.includedServicesName = includedServicesName;
        this.unit = unit;
        this.price = price;
    }

    public String getIncludedServicesName() {
        return includedServicesName;
    }

    public void setIncludedServicesName(String includedServicesName) {
        this.includedServicesName = includedServicesName;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public int compareTo(AvailableServices o) {
        return this.includedServicesName.compareTo(o.getIncludedServicesName());
    }
}
