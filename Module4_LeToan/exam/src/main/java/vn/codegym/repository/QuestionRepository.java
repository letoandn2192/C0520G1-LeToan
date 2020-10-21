package vn.codegym.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.Question;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {

    List<Question> findAll(Sort sort);

    List<Question> findAllByOrderByQuestionStatusDescQuestionDateCreateDesc();

//    List<Question> findByQuestionTypeQuestionTypeName(S)
}
