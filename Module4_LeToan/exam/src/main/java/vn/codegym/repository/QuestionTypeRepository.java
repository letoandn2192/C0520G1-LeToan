package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.QuestionType;

public interface QuestionTypeRepository extends JpaRepository<QuestionType, Long> {
}
