package vn.codegym.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
//@JsonIdentityInfo(
//        generator = ObjectIdGenerators.PropertyGenerator.class,
//        property = "educationDegreeId")
////@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class,property="@educationDegreeId", scope = EducationDegree.class)
public class EducationDegree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long educationDegreeId;
    private String educationDegreeName;

    @OneToMany(mappedBy = "educationDegree", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("educationDegree")
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
