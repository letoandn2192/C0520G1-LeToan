package vn.codegym.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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

    @Qualifier("studentServiceImpl")
    @Autowired
    private StudentService studentService;

    @GetMapping
    public String getStudentPage(Model model, @PageableDefault(value = 2) Pageable pageable) {
        model.addAttribute("studentList", studentService.findAll(pageable));
        return "/student/list";
    }

    @GetMapping("/create")
    public ModelAndView getCreatePage() {
        ModelAndView modelAndView = new ModelAndView("/student/create");
        modelAndView.addObject("student", new Student());

        List<String> languageList = new ArrayList<>();
        languageList.add("JAVA");
        languageList.add("C#");
        languageList.add("PHP");
        modelAndView.addObject("languageList", languageList);
        return modelAndView;
    }

    @PostMapping("/create")
    public String createStudent(@Validated @ModelAttribute Student student, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        new Student().validate(student, bindingResult);
        if (bindingResult.hasErrors()) {
            return "/student/create";
        } else {
            studentService.save(student);
            redirectAttributes.addFlashAttribute("ok", "da dang ki thanh cong");
            return "redirect:/student";
        }
    }


    @GetMapping("/edit/{id}")
    public ModelAndView getEditPage(@PathVariable int id) {

        ModelAndView modelAndView = new ModelAndView("/student/edit");
        //modelAndView.addObject("student", new Student());

        List<String> languageList = new ArrayList<>();
        languageList.add("JAVA");
        languageList.add("C#");
        languageList.add("PHP");
        modelAndView.addObject("languageList", languageList);
//        try {
        Student student = studentService.findById(id);
        modelAndView.addObject("student", student);
        if (student == null) {
            throw new NullPointerException("Khong tim thay student");
        }
//        } catch (NullPointerException e){
//            System.err.println(e);
//            return  new ModelAndView("redirect:/student");
//        }
        return modelAndView;
    }


    @PostMapping("/edit")
    public String editStudent(@ModelAttribute Student student) {
        studentService.update(student);
        return "redirect:/student";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable int id) {
        studentService.remove(id);
        return "redirect:/student";
    }

    @GetMapping("/search")
    public ModelAndView searchByName(@RequestParam String inputSearch) {
        return new ModelAndView("/student/list", "studentList", studentService.findByNameAndAddress(inputSearch));
    }
}
