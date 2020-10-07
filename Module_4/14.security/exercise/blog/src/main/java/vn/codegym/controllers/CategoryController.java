package vn.codegym.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import vn.codegym.model.Category;
import vn.codegym.service.CategoryService;

@Controller
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String getCategoryList(Model model) {
        model.addAttribute("categoryList", categoryService.findAll());
        return "/category/category-list";
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/category/category-create");
        modelAndView.addObject("category", new Category());
        return  modelAndView;
    }

    @PostMapping("/save")
    public String saveCategory(Category category) {
        categoryService.saveAndUpdate(category);
        return "redirect:/categories";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView("/category/category-edit");
        modelAndView.addObject("category", categoryService.findById(id));
        return  modelAndView;
    }

    @PostMapping("/update")
    public String updateChange(Category category) {
        categoryService.saveAndUpdate(category);
        return "redirect:/categories";
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView("/category/category-delete");
        modelAndView.addObject("category", categoryService.findById(id));
        return  modelAndView;
    }

    @PostMapping("/confirm")
    public String deleteCategory(Category category) {
        categoryService.delete(category.getCategoryId());
        return "redirect:/categories";
    }
}
