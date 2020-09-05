package model;

public class Service {
    private String serviceId;
    private String serviceName;
    private double serviceArea;
    private double serviceCost;
    private int serviceMaxPerson;
    private int rentTypeId;
    private int serviceTypeId;
    private String standardRoom;
    private String description;
    private double poolArea;
    private int numberFloor;

    public Service() {
    }

    public Service(String serviceId, String serviceName, double serviceArea, double serviceCost, int serviceMaxPerson, int rentTypeId, int serviceTypeId, String standardRoom, String description, int numberFloor) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.serviceArea = serviceArea;
        this.serviceCost = serviceCost;
        this.serviceMaxPerson = serviceMaxPerson;
        this.rentTypeId = rentTypeId;
        this.serviceTypeId = serviceTypeId;
        this.standardRoom = standardRoom;
        this.description = description;
        this.numberFloor = numberFloor;
    }

    public Service(String serviceId, String serviceName, double serviceArea, double serviceCost, int serviceMaxPerson, int rentTypeId, int serviceTypeId) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.serviceArea = serviceArea;
        this.serviceCost = serviceCost;
        this.serviceMaxPerson = serviceMaxPerson;
        this.rentTypeId = rentTypeId;
        this.serviceTypeId = serviceTypeId;
    }

    public Service(String serviceId, String serviceName, double serviceArea, double serviceCost, int serviceMaxPerson, int rentTypeId, int serviceTypeId, String standardRoom, String description, double poolArea, int numberFloor) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.serviceArea = serviceArea;
        this.serviceCost = serviceCost;
        this.serviceMaxPerson = serviceMaxPerson;
        this.rentTypeId = rentTypeId;
        this.serviceTypeId = serviceTypeId;
        this.standardRoom = standardRoom;
        this.description = description;
        this.poolArea = poolArea;
        this.numberFloor = numberFloor;
    }

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

    public int getRentTypeId() {
        return rentTypeId;
    }

    public void setRentTypeId(int rentTypeId) {
        this.rentTypeId = rentTypeId;
    }

    public int getServiceTypeId() {
        return serviceTypeId;
    }

    public void setServiceTypeId(int serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberFloor() {
        return numberFloor;
    }

    public void setNumberFloor(int numberFloor) {
        this.numberFloor = numberFloor;
    }
}
