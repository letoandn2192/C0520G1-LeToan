package vn.codegym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.RandomCode;
import vn.codegym.repository.RandomCodeRepository;

@Service
public class RandomCodeServiceImpl implements RandomCodeService {
    @Autowired
    private RandomCodeRepository randomCodeRepository;
    @Override
    public Iterable<RandomCode> findAll() {
        return randomCodeRepository.findAll();
    }

    @Override
    public RandomCode findById(int id) {
        return randomCodeRepository.findById(id).orElse(null);
    }

    @Override
    public void save(RandomCode code) {
        randomCodeRepository.save(code);
    }

    @Override
    public void delete(int id) {
        randomCodeRepository.deleteById(id);
    }

    @Override
    public RandomCode findByBookAndCode(int bookId, int code) {
        return randomCodeRepository.findRandomCodeByBook_BookIdAndRandomCode(bookId, code);
    }
}
