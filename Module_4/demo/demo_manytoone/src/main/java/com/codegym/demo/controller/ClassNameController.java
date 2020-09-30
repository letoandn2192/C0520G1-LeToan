package com.codegym.demo.controller;

import com.codegym.demo.model.ClassName;
import com.codegym.demo.model.Student;
import com.codegym.demo.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("class")
public class ClassNameController {
    @Autowired
    private ClassService classService;
    @GetMapping()
    private ModelAndView getAll() {
        List<ClassName> listClass = classService.findAll();
        return new ModelAndView("class/listClass", "class", listClass);
    }
    @GetMapping("/{id}")
    public ModelAndView view(@PathVariable long id) {
        return new ModelAndView("class/detailClass", "className", classService.getById(id));
    }
}
