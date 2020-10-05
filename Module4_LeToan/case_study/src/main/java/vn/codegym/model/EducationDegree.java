package vn.codegym.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class EducationDegree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long educationDegreeId;
    private String educationDegreeName;

    @OneToMany(mappedBy = "educationDegree", cascade = CascadeType.ALL)
    private Set<Employee> employees;

    public long getEducationDegreeId() {
        return educationDegreeId;
    }

    public void setEducationDegreeId(long educationDegreeId) {
        this.educationDegreeId = educationDegreeId;
    }

    public String getEducationDegreeName() {
        return educationDegreeName;
    }

    public void setEducationDegreeName(String educationDegreeName) {
        this.educationDegreeName = educationDegreeName;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
