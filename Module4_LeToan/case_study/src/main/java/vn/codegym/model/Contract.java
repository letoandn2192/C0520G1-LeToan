package vn.codegym.model;

import vn.codegym.common.validate_future_date.ValidateFutureDate;
import vn.codegym.common.validate_start_end_day.ValidateStartBeforeEndDate;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import java.util.Set;

@Entity
@Table
//@ValidateStartBeforeEndDate
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long contractId;

    @ValidateFutureDate
    private String contractStartDate;

    @ValidateFutureDate
    private String contractEndDate;

    @Positive
    private double contractDeposit;

    @Positive
    private double contractTotalMoney;

    @ManyToOne
    @JoinColumn(name = "employeeId")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "serviceId")
    private Services service;

    @OneToMany(mappedBy = "contract", cascade = CascadeType.ALL)
    private Set<ContractDetail> contractDetails;

    public long getContractId() {
        return contractId;
    }

    public void setContractId(long contractId) {
        this.contractId = contractId;
    }

    public String getContractStartDate() {
        return contractStartDate;
    }

    public void setContractStartDate(String contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    public String getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(String contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    public double getContractDeposit() {
        return contractDeposit;
    }

    public void setContractDeposit(double contractDeposit) {
        this.contractDeposit = contractDeposit;
    }

    public double getContractTotalMoney() {
        return contractTotalMoney;
    }

    public void setContractTotalMoney(double contractTotalMoney) {
        this.contractTotalMoney = contractTotalMoney;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employees) {
        this.employee = employees;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Services getService() {
        return service;
    }

    public void setService(Services service) {
        this.service = service;
    }

    public Set<ContractDetail> getContractDetails() {
        return contractDetails;
    }

    public void setContractDetails(Set<ContractDetail> contractDetails) {
        this.contractDetails = contractDetails;
    }
}
