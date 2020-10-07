package vn.codegym.session.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.session.model.Product;
import vn.codegym.session.service.ProductService;

@Controller
@RequestMapping("product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public ModelAndView showListPage() {
        return new ModelAndView("product/list_2", "productList", productService.findAll());
    }

    @GetMapping("/detail/{id}")
    public ModelAndView showDetailPage(@PathVariable long id) {
        return new ModelAndView("product/detail","product", productService.findById(id));
    }

    @GetMapping("/create")
    public ModelAndView showCreatePage(){
        return new ModelAndView("product/create", "product", new Product());
    }

    @PostMapping("/create")
    public String createProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes){
        productService.save(product);
        redirectAttributes.addFlashAttribute("success","Create new product name: " + product.getName());
        return "redirect:/product";
    }
}
