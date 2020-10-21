package vn.codegym.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.model.Question;
import vn.codegym.model.QuestionType;
import vn.codegym.model.User;
import vn.codegym.service.QuestionService;
import vn.codegym.service.QuestionTypeService;
import vn.codegym.service.UserService;

import java.time.LocalDate;
import java.util.List;

@Controller
public class QuestionController {
    @Autowired
    private QuestionTypeService questionTypeService;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private UserService userService;

    @ModelAttribute("questionTypeList")
    public List<QuestionType> getQuestionTypeList() {
        return questionTypeService.findAll();
    }

    @ModelAttribute("userList")
    public List<User> getUserList() {
        return userService.findAll();
    }
    @GetMapping("")
    public String getQuestionList(Model model, @RequestParam(value = "inputSearch", defaultValue = "") String inputSearch,
                                  @RequestParam(value = "select", defaultValue = "") String select) {
//        model.addAttribute("questionList", questionService.findAll());
        model.addAttribute("questionList", questionService.findAllSort());
        model.addAttribute("inputSearch", inputSearch);
        model.addAttribute("select", select);
        return "question/question-list";
    }

    @GetMapping("/create")
    public ModelAndView showCreateQuestionForm() {
        ModelAndView modelAndView = new ModelAndView("question/question-create");
        modelAndView.addObject("question", new Question());
        return modelAndView;
    }

    @PostMapping("/save")
    public String createNewQuestion(@Validated Question question, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "question/question-create";
        } else {
            question.setQuestionDateCreate(LocalDate.now());
            question.setUser(userService.findById(1));
            question.setQuestionStatus("Finish");
            question.setQuestionAnswer("Waitting for loading");
            questionService.save(question);
            redirectAttributes.addFlashAttribute("messInform", "Create Successful!!!");
            return "redirect:/";
        }
    }

    @GetMapping("/detail/{id}")
    public ModelAndView showQuestionInformation(@PathVariable(value = "id") long id) {
        ModelAndView modelAndView = new ModelAndView("question/question-detail");
        modelAndView.addObject("question", questionService.findById(id));
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable(value = "id") long id) {
        ModelAndView modelAndView = new ModelAndView("question/question-edit");
        modelAndView.addObject("question", questionService.findById(id));
        return modelAndView;
    }

    @PostMapping("/update")
    public String editQuestionInformation(@Validated Question question, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "question/question-edit";
        } else {
            questionService.save(question);
            redirectAttributes.addFlashAttribute("messInform", "Edit Successful!!!");
            return "redirect:/";
        }
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable("id") long id) {
        ModelAndView modelAndView = new ModelAndView("/question/question-delete");
        Question question = questionService.findById(id);
        modelAndView.addObject("question", question);
        return  modelAndView;
    }

    @PostMapping("/confirm")
    public String deleteProduct(Question product, RedirectAttributes redirectAttributes) {
        questionService.deleteById(product.getQuestionId());
        redirectAttributes.addFlashAttribute("messInform", "Delete Successful!!!");
        return "redirect:/";
    }

}
