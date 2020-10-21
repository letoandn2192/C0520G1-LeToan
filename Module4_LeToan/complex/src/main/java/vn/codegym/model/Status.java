package vn.codegym.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long statusId;
    private String statusName;

    @OneToMany(mappedBy = "complexStatus", cascade = CascadeType.ALL)
    private Collection<Complex> complexes;

    public long getStatusId() {
        return statusId;
    }

    public void setStatusId(long statusId) {
        this.statusId = statusId;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public Collection<Complex> getComplexes() {
        return complexes;
    }

    public void setComplexes(Collection<Complex> complexes) {
        this.complexes = complexes;
    }
}
