package com.codegym.demo.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table
public class ClassName {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long idClass;


    String nameClass;

    @OneToMany(mappedBy = "className", cascade = CascadeType.ALL)
    Collection<Student> students;


    public long getIdClass() {
        return idClass;
    }

    public void setIdClass(long idClass) {
        this.idClass = idClass;
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }

    public Collection<Student> getStudents() {
        return students;
    }

    public void setStudents(Collection<Student> students) {
        this.students = students;
    }

}
