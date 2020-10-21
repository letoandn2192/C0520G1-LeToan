package vn.codegym.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long typeId;
    private String typeName;

    @OneToMany(mappedBy = "complexType", cascade = CascadeType.ALL)
    private Collection<Complex> complexes;

    public long getTypeId() {
        return typeId;
    }

    public void setTypeId(long typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Collection<Complex> getComplexes() {
        return complexes;
    }

    public void setComplexes(Collection<Complex> complexes) {
        this.complexes = complexes;
    }
}
