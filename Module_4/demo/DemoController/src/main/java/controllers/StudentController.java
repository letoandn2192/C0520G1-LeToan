package controllers;

import model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import service.StudentService;
import service.StudentServiceImpl;

@Controller
@RequestMapping("/student")
public class StudentController {
    private StudentService studentService = new StudentServiceImpl();

    @GetMapping
    public String getStudentPage(Model model){
        model.addAttribute("studentList",studentService.findAll());
        return "/student/list";
    }

    @GetMapping("/create")
    public String getCreatePage(){
        return "/student/create";
    }

    @PostMapping("/create")
    public String createStudent(@RequestParam int id, String name, String address, int age){
        studentService.save(new Student(id, name, address, age));
        return "redirect:/student";
    }

    @GetMapping("/edit/{id}")
    public String getEditPage(@PathVariable int id, Model model){
        model.addAttribute("student", studentService.findById(id));
        return "/student/edit";
    }

    @PostMapping("/edit")
    public String editStudent(@RequestParam int id, String name, String address, int age, RedirectAttributes redirectAttributes){
        studentService.update(id, new Student(id, name, address, age));
        redirectAttributes.addFlashAttribute("student",  new Student(id, name, address, age));
        return "redirect:/student/confirm";
    }

    @GetMapping("/confirm")
    public String confirmStudent(@ModelAttribute("student") Student studentIn, Model model){
        model.addAttribute("student", studentIn);
        return "/student/confirm";
    }
}
