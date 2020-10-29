package vn.codegym.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long roleId;
    private String roleName;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "role_user", joinColumns = @JoinColumn(name = "roleId"), inverseJoinColumns = @JoinColumn(name = "userId"))
    private Set<User> users;

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> userList) {
        this.users = userList;
    }
}
