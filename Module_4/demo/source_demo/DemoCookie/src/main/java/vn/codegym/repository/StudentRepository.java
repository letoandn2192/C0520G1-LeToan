package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.codegym.model.Student;

import java.util.List;


public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findByNameAndAddress(String name, String address);

    List<Student> findByNameContainingOrAddressContaining(String name, String address);


    @Query("select s from Student s where s.name = :input and s.age > 15")
    List<Student> findByName(@Param("input") String name);

}
