package vn.codegym.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import vn.codegym.model.Question;

import java.util.List;

public interface QuestionService {
    List<Question> findAll();

    List<Question> findAllSort();

    List<Question> findAll(Sort sort);

    Question findById(long id);

    void save(Question question);

    void deleteById(long id);
}
