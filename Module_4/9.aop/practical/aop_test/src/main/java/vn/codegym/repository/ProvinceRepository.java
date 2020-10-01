package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.Province;

public interface ProvinceRepository extends JpaRepository<Province, Integer> {
}
