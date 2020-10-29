package vn.codegym.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class CustomerType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long customerTypeId;
    private String customerTypeName;

    @OneToMany(mappedBy = "customerType", cascade = CascadeType.ALL)
//    @JsonBackReference
    private Set<Customer> customers;

    public long getCustomerTypeId() {
        return customerTypeId;
    }

    public void setCustomerTypeId(long customerTypeId) {
        this.customerTypeId = customerTypeId;
    }

    public String getCustomerTypeName() {
        return customerTypeName;
    }

    public void setCustomerTypeName(String customerTypeName) {
        this.customerTypeName = customerTypeName;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }
}
