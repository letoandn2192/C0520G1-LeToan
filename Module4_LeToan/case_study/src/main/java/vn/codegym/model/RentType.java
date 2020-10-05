package vn.codegym.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class RentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long rentTypeId;
    private String rentTypeName;
    private double rentTypeCost;

    @OneToMany(mappedBy = "rentType", cascade = CascadeType.ALL)
    private Set<Service> services;

    public long getRentTypeId() {
        return rentTypeId;
    }

    public void setRentTypeId(long rentTypeId) {
        this.rentTypeId = rentTypeId;
    }

    public String getRentTypeName() {
        return rentTypeName;
    }

    public void setRentTypeName(String rentTypeName) {
        this.rentTypeName = rentTypeName;
    }

    public double getRentTypeCost() {
        return rentTypeCost;
    }

    public void setRentTypeCost(double rentTypeCost) {
        this.rentTypeCost = rentTypeCost;
    }

    public Set<Service> getServices() {
        return services;
    }

    public void setServices(Set<Service> services) {
        this.services = services;
    }
}
