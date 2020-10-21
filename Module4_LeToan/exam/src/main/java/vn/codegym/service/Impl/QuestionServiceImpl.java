package vn.codegym.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import vn.codegym.model.Question;
import vn.codegym.repository.QuestionRepository;
import vn.codegym.service.QuestionService;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public List<Question> findAll() {
        return questionRepository.findAll();
    }

    @Override
    public List<Question> findAllSort() {
        return questionRepository.findAllByOrderByQuestionStatusDescQuestionDateCreateDesc();
    }

    @Override
    public List<Question> findAll(Sort sort) {
        return questionRepository.findAll(sort);
    }

    @Override
    public Question findById(long id) {
        return questionRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Question question) {
        questionRepository.save(question);
    }

    @Override
    public void deleteById(long id) {
        questionRepository.deleteById(id);
    }
}
