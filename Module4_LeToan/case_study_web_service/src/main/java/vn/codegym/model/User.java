package vn.codegym.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class User {
    @Id
    private String userName;
    private String password;

    @ManyToMany(mappedBy = "users")
    private Set<Role> roles;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Employee> employees;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roleList) {
        this.roles = roleList;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
