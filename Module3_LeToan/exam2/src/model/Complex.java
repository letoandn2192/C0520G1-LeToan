package model;

public class Complex {
    private String complexCode;
    private String complexStatus;
    private double complexArea;
    private int complexFloor;
    private String complexType;
    private double complexCost;
    private String complexStartDate;
    private String complexEndDate;

    public Complex() {
    }

    public Complex(String complexCode, String complexStatus, double complexArea, int complexFloor, String complexType, double complexCost, String complexStartDate, String complexEndDate) {
        this.complexCode = complexCode;
        this.complexStatus = complexStatus;
        this.complexArea = complexArea;
        this.complexFloor = complexFloor;
        this.complexType = complexType;
        this.complexCost = complexCost;
        this.complexStartDate = complexStartDate;
        this.complexEndDate = complexEndDate;
    }

    public String getComplexCode() {
        return complexCode;
    }

    public void setComplexCode(String complexCode) {
        this.complexCode = complexCode;
    }

    public String getComplexStatus() {
        return complexStatus;
    }

    public void setComplexStatus(String complexStatus) {
        this.complexStatus = complexStatus;
    }

    public double getComplexArea() {
        return complexArea;
    }

    public void setComplexArea(double complexArea) {
        this.complexArea = complexArea;
    }

    public int getComplexFloor() {
        return complexFloor;
    }

    public void setComplexFloor(int complexFloor) {
        this.complexFloor = complexFloor;
    }

    public String getComplexType() {
        return complexType;
    }

    public void setComplexType(String complexType) {
        this.complexType = complexType;
    }

    public double getComplexCost() {
        return complexCost;
    }

    public void setComplexCost(double complexCost) {
        this.complexCost = complexCost;
    }

    public String getComplexStartDate() {
        return complexStartDate;
    }

    public void setComplexStartDate(String complexStartDate) {
        this.complexStartDate = complexStartDate;
    }

    public String getComplexEndDate() {
        return complexEndDate;
    }

    public void setComplexEndDate(String complexEndDate) {
        this.complexEndDate = complexEndDate;
    }
}
