package vn.codegym.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vn.codegym.model.Course;
import vn.codegym.model.Student;
import vn.codegym.service.CourseService;
import vn.codegym.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    @ModelAttribute("courseList")
    public Iterable<Course> getCourseList() {
        return courseService.findAll();
    }

    @GetMapping
    public String showStudentList(Model model) {
        model.addAttribute("studentList", studentService.findAll());
        return "student/student-list";
    }

    @GetMapping("/create")
    public ModelAndView showCreateStudentForm() {
        ModelAndView modelAndView = new ModelAndView("student/student-create");
        modelAndView.addObject("student", new Student());
        return modelAndView;
    }

    @PostMapping("/save")
    public String saveStudent(Student student) {
        studentService.save(student);
        return "redirect:/student";
    }

    @GetMapping("/register/{id}")
    public ModelAndView showRegisterForm(@PathVariable("id") long id) {
        ModelAndView modelAndView = new ModelAndView("student/student-course");
        modelAndView.addObject("student", studentService.findById(id));
        return modelAndView;
    }

    @PostMapping("/finish")
    public String finishRegister(Student student) {
//        student.getCourses().addAll(studentService.findById(student.getStudentId()).getCourses());
        studentService.save(student);
        return "redirect:/student";
    }
}
