package com.codegym.demo.controller;

import com.codegym.demo.model.ClassName;
import com.codegym.demo.model.Student;
import com.codegym.demo.service.ClassService;
import com.codegym.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private ClassService classService;

    @GetMapping()
    private ModelAndView getAll() {
        List<Student> listStudent = studentService.findAll();
        return new ModelAndView("student/listStu", "students", listStudent);
    }

    @GetMapping("/add")
    public ModelAndView formRegister() {
        ModelAndView modelAndView = new ModelAndView("student/add" );
        List<ClassName> classNameList = classService.findAll();
        modelAndView.addObject("student", new Student());
        modelAndView.addObject("classNames", classNameList);
        return modelAndView;
    }

    @PostMapping("/add")
    private String addStudent(Student student) {
        studentService.save(student);
        return "redirect:/student";
    }
}
