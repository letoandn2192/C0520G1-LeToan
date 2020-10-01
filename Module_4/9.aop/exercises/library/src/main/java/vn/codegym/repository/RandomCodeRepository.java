package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.RandomCode;

public interface RandomCodeRepository extends JpaRepository<RandomCode, Integer> {
    RandomCode findRandomCodeByBook_BookIdAndRandomCode(int bookId, int randomCode);
}
