package vn.codegym.product_manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import vn.codegym.product_manager.model.Category;
import vn.codegym.product_manager.service.CategoryService;

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
    public String saveChange(Category category) {
        categoryService.saveAndUpdate(category);
        return "redirect:/categories";
    }
}
