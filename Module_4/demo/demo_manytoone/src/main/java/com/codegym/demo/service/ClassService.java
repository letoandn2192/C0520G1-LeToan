package com.codegym.demo.service;

import com.codegym.demo.model.ClassName;

import java.util.List;

public interface ClassService {
    List<ClassName> findAll();
    ClassName getById(long id);
}
