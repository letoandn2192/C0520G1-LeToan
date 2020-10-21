package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.Complex;

import java.util.List;

public interface ComplexRepository extends JpaRepository<Complex, String> {
    List<Complex> findAllByOrderByComplexFloorDesc();
}
