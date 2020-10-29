package vn.codegym.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class ServiceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long serviceTypeId;
    private String serviceTypeName;

    @OneToMany(mappedBy = "serviceType", cascade = CascadeType.ALL)
    private Set<Services> services;

    public long getServiceTypeId() {
        return serviceTypeId;
    }

    public void setServiceTypeId(long serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
    }

    public String getServiceTypeName() {
        return serviceTypeName;
    }

    public void setServiceTypeName(String serviceTypeName) {
        this.serviceTypeName = serviceTypeName;
    }

    public Set<Services> getServices() {
        return services;
    }

    public void setServices(Set<Services> services) {
        this.services = services;
    }
}
