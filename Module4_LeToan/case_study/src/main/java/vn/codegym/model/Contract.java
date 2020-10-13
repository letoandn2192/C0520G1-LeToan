package vn.codegym.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import vn.codegym.common.validate_future_date.ValidateFutureDate;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Entity
@Table
public class Contract implements Validator{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long contractId;

//    @ValidateFutureDate
    private String contractStartDate;

//    @ValidateFutureDate
    private String contractEndDate;

//    @Positive
    private double contractDeposit;

//    @Positive
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

    @Override
    public boolean supports(Class<?> clazz) {
        return Contract.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Contract contract = (Contract) target;
        String sDate = contract.getContractStartDate();
        String eDate = contract.getContractEndDate();
        if (!checkValidateDate(sDate)) {
            errors.rejectValue("contractStartDate", "contractStartDate.startDate");
        }
        if (!checkValidateDate(eDate)) {
            errors.rejectValue("contractEndDate", "contractEndDate.endDate");
        }
        if (checkValidateDate(sDate) && checkValidateDate(eDate)) {
            LocalDate startDate = LocalDate.parse(changeFormatDate(sDate));
            LocalDate endDate = LocalDate.parse(changeFormatDate(eDate));
            if (startDate.isAfter(endDate)) {
                errors.rejectValue("contractEndDate", "contractEndDate.startDateBeforeEndDate");
            }
        }
        double total = contract.getContractTotalMoney();
        double deposit = contract.getContractDeposit();
        if(deposit <= 0) {
            errors.rejectValue("contractDeposit", "contractDeposit.depositPositive");
        }
        if(total <= 0) {
            errors.rejectValue("contractTotalMoney", "contractTotalMoney.totalMoneyPositive");
        }
        if (deposit > total) {
            errors.rejectValue("contractTotalMoney", "contractTotalMoney.totalMoney");
        }
    }

    private String changeFormatDate(String input) {
        String[] array = input.split("/");
        return array[2]+'-'+array[1]+'-'+array[0];
    }

    private boolean checkValidateDate(String input) {
        Pattern pattern = Pattern.compile("^(?=\\d{2}([-.,\\/])\\d{2}\\1\\d{4}$)(?:0[1-9]|1\\d|[2][0-8]|29(?!.02.(?!(?!(?:[02468][1-35-79]|[13579][0-13-57-9])00)\\d{2}(?:[02468][048]|[13579][26])))|30(?!.02)|31(?=.(?:0[13578]|10|12))).(?:0[1-9]|1[012]).\\d{4}$");
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
}
