package vn.codegym.model;

import vn.codegym.common.validate_service_id.ValidateServiceId;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.util.Set;

@Entity
@Table
public class Services {
    public interface IdCheck {};
    public interface RoomCheck {};
    public interface HouseCheck {};
    public interface VillaCheck {};
    @Id
    @ValidateServiceId(groups = IdCheck.class)
    private String serviceId;

    @NotEmpty(message = "Name not be empty!!!", groups = RoomCheck.class)
    private String serviceName;

    @Positive(message = "Name not be empty!!!",groups = RoomCheck.class)
    private double serviceArea;

    @Positive(message = "Name not be empty!!!",groups = RoomCheck.class)
    private double serviceCost;

    @Positive(message = "Name not be empty!!!",groups = RoomCheck.class)
    private int serviceMaxPerson;

    @NotEmpty(message = "Name not be empty!!!",groups = HouseCheck.class)
    private String serviceStandardRoom;

    @NotEmpty(message = "Name not be empty!!!",groups = HouseCheck.class)
    private String serviceDescription;

    @Positive(message = "Name not be empty!!!",groups = VillaCheck.class)
    private double servicePoolArea;

    @Positive(message = "Name not be empty!!!",groups = HouseCheck.class)
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
