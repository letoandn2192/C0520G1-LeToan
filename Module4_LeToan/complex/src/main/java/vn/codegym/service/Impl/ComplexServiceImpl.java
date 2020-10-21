package vn.codegym.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.Complex;
import vn.codegym.repository.ComplexRepository;
import vn.codegym.service.ComplexService;

import java.util.List;

@Service
public class ComplexServiceImpl implements ComplexService {
    @Autowired
    private ComplexRepository complexRepository;

    @Override
    public List<Complex> findAll() {
        return complexRepository.findAll();
    }

    @Override
    public List<Complex> findAllSortFloorDesc() {
        return complexRepository.findAllByOrderByComplexFloorDesc();
    }

    @Override
    public Complex findById(String id) {
        return complexRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Complex complex) {
        complexRepository.save(complex);
    }

    @Override
    public void deleteById(String id) {
        complexRepository.deleteById(id);
    }
}
