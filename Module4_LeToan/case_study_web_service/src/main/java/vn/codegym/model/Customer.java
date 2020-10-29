package vn.codegym.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import vn.codegym.common.validate_birthday.ValidateBirthdayGreater18;
//import vn.codegym.common.validate_customer_id.ValidateCustomerId;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Set;

@Entity
@Table
public class Customer {
    public interface EditCheck {};
    public interface IdCheck {};
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long customerId;

    @NotEmpty(message = "Name must not be empty", groups = EditCheck.class)
    private String customerName;

    @ValidateBirthdayGreater18(groups = EditCheck.class)
    private String customerBirthday;

    private boolean customerGender;

    @Pattern(regexp = "^((\\d{9})|(\\d{12}))$", message = "Id card format is XXXXXXXXX or XXXXXXXXXXXX", groups = EditCheck.class)
    private String customerIdCard;

    @Pattern(regexp = "^(090|091|\\(84\\)\\+90|\\(84\\)\\+91)\\d{7}$", message = "Format is 090xxxxxxx, 091xxxxxxx, (84)+90xxxxxxx, (84)+91xxxxxxx", groups = EditCheck.class)
    private String customerPhone;

    @Pattern(regexp = "^(\\w{3,}@\\w+\\.\\w+)$", message = "Email follow format abc@abc.abc", groups = EditCheck.class)
    private String customerEmail;

    @NotEmpty(message = "Address not be empty!!!", groups = EditCheck.class)
    private String customerAddress;

    @ManyToOne
    @JoinColumn(name = "customerTypeId")
//    JsonIgnore khong chuyen doi du lieu sang json
    @JsonIgnore
//    @JsonBackReference
    private CustomerType customerType;

    @OneToMany(mappedBy = "customer", cascade =  CascadeType.ALL)
    private Set<Contract> contracts;

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerBirthday() {
        return customerBirthday;
    }

    public void setCustomerBirthday(String customerBirthday) {
        this.customerBirthday = customerBirthday;
    }

    public boolean isCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(boolean customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerIdCard() {
        return customerIdCard;
    }

    public void setCustomerIdCard(String customerIdCard) {
        this.customerIdCard = customerIdCard;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }
}
