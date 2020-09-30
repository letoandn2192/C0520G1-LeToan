package vn.codegym.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vn.codegym.model.Course;
import vn.codegym.model.Student;
import vn.codegym.service.CourseService;
import vn.codegym.service.StudentService;

import java.util.List;

@Controller
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @Autowired
    private StudentService studentService;

    @ModelAttribute("studentList")
    public Iterable<Student> getStudentList() {
        return studentService.findAll();
    }

    @GetMapping
    public String showCourseList(Model model) {
        model.addAttribute("courseList", courseService.findAll());
        return "course/course-list";
    }

    @GetMapping("/create")
    public ModelAndView showCreateCourseForm() {
        ModelAndView modelAndView = new ModelAndView("course/course-create");
        modelAndView.addObject("course", new Course());
        return modelAndView;
    }

    @PostMapping("/save")
    public String saveCourse(Course course) {
//        course.setStudents(studentService.findStudentIdIsIn(idList));
        courseService.save(course);
        return "redirect:/course";
    }

    @GetMapping("/view/{id}")
    public ModelAndView showStudentInCourse(@PathVariable("id") long id) {
        ModelAndView modelAndView = new ModelAndView("course/course-view");
        modelAndView.addObject("course", courseService.findById(id));
        return modelAndView;
    }
}
