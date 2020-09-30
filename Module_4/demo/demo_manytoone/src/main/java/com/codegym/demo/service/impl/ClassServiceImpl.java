package com.codegym.demo.service.impl;

import com.codegym.demo.model.ClassName;
import com.codegym.demo.repository.ClassRepository;
import com.codegym.demo.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {
    @Autowired
    ClassRepository classRepository;
    @Override
    public List<ClassName> findAll() {
        return classRepository.findAll();
    }

    @Override
    public ClassName getById(long id) {
        return classRepository.getOne(id);
    }
}
