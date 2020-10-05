package vn.codegym.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;
import vn.codegym.model.CartItems;
import vn.codegym.model.Product;
import vn.codegym.service.ProductService;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("")
    public String showProductList(Model model) {
        model.addAttribute("productList", (List<Product>) productService.findAll());
        return "product/list";
    }

    @GetMapping("/create")
    public ModelAndView showCreateProductForm() {
        ModelAndView modelAndView = new ModelAndView("/product/create");
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }

    @PostMapping("/save")
    public String createNewProduct(Product product) {
        productService.save(product);
        return "redirect:";
    }

    @GetMapping("/view/{id}")
    public ModelAndView showProductInformation(@PathVariable("id") long id) {
        return new ModelAndView("product/view", "product", productService.findById(id));
    }
}
