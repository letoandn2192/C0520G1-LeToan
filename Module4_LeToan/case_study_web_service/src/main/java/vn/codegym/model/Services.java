package vn.codegym.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.Min;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long serviceId;

    @NotEmpty(message = "Name not be empty!!!", groups = {VillaCheck.class, HouseCheck.class, RoomCheck.class})
    private String serviceName;

    @Positive(message = "Area must be positive!!!", groups = {VillaCheck.class, HouseCheck.class, RoomCheck.class})
    @Min(value = 30, message = "Area at least is 30 m2", groups = {VillaCheck.class, HouseCheck.class, RoomCheck.class})
    private double serviceArea;

    @Positive(message = "Cost must be positive!!!", groups = {VillaCheck.class, HouseCheck.class, RoomCheck.class})
    private double serviceCost;

    @Positive(message = "Person must be positive!!!", groups = {VillaCheck.class, HouseCheck.class, RoomCheck.class})
    private int serviceMaxPerson;

    @NotEmpty(message = "Must be not empty!!!", groups = {VillaCheck.class, HouseCheck.class})
    private String serviceStandardRoom;

    @NotEmpty(message = "Must be not empty!!!", groups = {VillaCheck.class, HouseCheck.class})
    private String serviceDescription;

    @Positive(message = "Pool Area must be positive!!!", groups = VillaCheck.class)
    @Min(value = 30, message = "Pool Area at least is 30 m2", groups = VillaCheck.class)
    private double servicePoolArea;

    @Positive(message = "Floor must be positive!!!", groups = {VillaCheck.class, HouseCheck.class})
    private int serviceFloor;

    @ManyToOne
    @JoinColumn(name = "serviceTypeId")
    @JsonIgnoreProperties("services")
    private ServiceType serviceType;

    @ManyToOne
    @JoinColumn(name = "rentTypeId")
    @JsonIgnoreProperties("services")
    private RentType rentType;

    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("service")
    private Set<Contract> contracts;

    public long getServiceId() {
        return serviceId;
    }

    public void setServiceId(long serviceId) {
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
