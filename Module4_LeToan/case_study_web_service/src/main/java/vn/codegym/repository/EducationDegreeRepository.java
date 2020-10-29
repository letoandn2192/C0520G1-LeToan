package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.EducationDegree;

public interface EducationDegreeRepository extends JpaRepository<EducationDegree, Long> {
}
