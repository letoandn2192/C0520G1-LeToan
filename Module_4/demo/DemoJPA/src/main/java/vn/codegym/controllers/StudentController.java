package vn.codegym.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.model.Student;
import vn.codegym.service.StudentService;

import java.util.ArrayList;
import java.util.List;

@Component
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public String getStudentPage(Model model){
        model.addAttribute("studentList",studentService.findAll());
        return "/student/list";
    }

    @GetMapping("/create")
    public ModelAndView getCreatePage(){
        ModelAndView modelAndView  = new ModelAndView("/student/create");
        modelAndView.addObject("student", new Student());

        List<String> languageList = new ArrayList<>();
        languageList.add("JAVA");
        languageList.add("C#");
        languageList.add("PHP");
        modelAndView.addObject("languageList", languageList);
        return modelAndView;
    }

    @PostMapping("/create")
    public String createStudent(@ModelAttribute Student student, RedirectAttributes redirectAttributes){
        studentService.save(student);
        redirectAttributes.addFlashAttribute("ok","da dang ki thanh cong");
        return "redirect:/student";
    }


    @GetMapping("/edit/{id}")
    public ModelAndView getEditPage(@PathVariable int id){
        ModelAndView modelAndView  = new ModelAndView("/student/edit");
        modelAndView.addObject("student", new Student());

        List<String> languageList = new ArrayList<>();
        languageList.add("JAVA");
        languageList.add("C#");
        languageList.add("PHP");
        modelAndView.addObject("languageList", languageList);
        modelAndView.addObject("student", studentService.findById(id));
        return modelAndView;
    }


    @PostMapping("/edit")
    public String editStudent(@ModelAttribute Student student){
        studentService.update(student);

        return "redirect:/student";
    }
}
