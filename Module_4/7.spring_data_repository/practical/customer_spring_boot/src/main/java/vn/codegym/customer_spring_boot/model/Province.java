package vn.codegym.customer_spring_boot.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Province {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int provinceId;
    private String provinceName;

    @OneToMany(targetEntity = Province.class)
    private List<Province> customers;

    public Province() {
    }

    public Province(int provinceId, String provinceName) {
        this.provinceId = provinceId;
        this.provinceName = provinceName;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public List<Province> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Province> customers) {
        this.customers = customers;
    }
}
