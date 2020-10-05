package vn.codegym.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class Service {
    @Id
    private String serviceId;
    private String serviceName;
    private double serviceArea;
    private double serviceCost;
    private int serviceMaxPerson;
    private String serviceStandardRoom;
    private String serviceDescription;
    private double servicePoolArea;
    private int serviceFloor;

    @ManyToOne
    @JoinColumn(name = "serviceTypeId")
    private ServiceType serviceType;

    @ManyToOne
    @JoinColumn(name = "rentTypeId")
    private RentType rentType;

    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL)
    private Set<Contract> contracts;

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(double serviceArea) {
        this.serviceArea = serviceArea;
    }

    public double getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(double serviceCost) {
        this.serviceCost = serviceCost;
    }

    public int getServiceMaxPerson() {
        return serviceMaxPerson;
    }

    public void setServiceMaxPerson(int serviceMaxPerson) {
        this.serviceMaxPerson = serviceMaxPerson;
    }

    public String getServiceStandardRoom() {
        return serviceStandardRoom;
    }

    public void setServiceStandardRoom(String serviceStandardRoom) {
        this.serviceStandardRoom = serviceStandardRoom;
    }

    public String getServiceDescription() {
        return serviceDescription;
    }

    public void setServiceDescription(String serviceDescription) {
        this.serviceDescription = serviceDescription;
    }

    public double getServicePoolArea() {
        return servicePoolArea;
    }

    public void setServicePoolArea(double servicePoolArea) {
        this.servicePoolArea = servicePoolArea;
    }

    public int getServiceFloor() {
        return serviceFloor;
    }

    public void setServiceFloor(int serviceFloor) {
        this.serviceFloor = serviceFloor;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }
}
