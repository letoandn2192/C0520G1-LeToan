package vn.codegym.model;

import org.springframework.data.annotation.TypeAlias;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long divisionId;
    private String divisionName;

    @OneToMany(mappedBy = "division", cascade = CascadeType.ALL)
    private Set<Employee> employees;

    public long getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(long divisionId) {
        this.divisionId = divisionId;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
