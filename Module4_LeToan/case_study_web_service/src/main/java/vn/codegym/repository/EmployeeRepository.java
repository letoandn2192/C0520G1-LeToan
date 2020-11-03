package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
