package vn.codegym.product_manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vn.codegym.product_manager.model.Category;
import vn.codegym.product_manager.model.Product;
import vn.codegym.product_manager.service.CategoryService;
import vn.codegym.product_manager.service.ProductService;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @ModelAttribute("categories")
    public Iterable<Category> categories () {
        return categoryService.findAll();
    }

    @GetMapping
    public String getProductList(Model model, @PageableDefault(value = 5) Pageable pageable) {
        model.addAttribute("productList", productService.findAll(pageable));
        model.addAttribute("mode", "display");
        return "/product/product-list";
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/product/product-create");
        modelAndView.addObject("product", new Product());
        return  modelAndView;
    }

    @PostMapping("/save")
    public String saveNewProduct(Product product) {
        productService.saveAndUpdate(product);
        return "redirect:/products";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable("id") long id, @PageableDefault(value = 5) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/product/product-list");
        Product product = productService.findById(id);
        modelAndView.addObject("productList", productService.findAll(pageable));
        modelAndView.addObject("product", product);
        modelAndView.addObject("mode", "edit");
        return  modelAndView;
    }

    @PostMapping("/update")
    public String editProduct(Product product) {
        productService.saveAndUpdate(product);
        return "redirect:/products";
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable("id") long id) {
        ModelAndView modelAndView = new ModelAndView("/product/product-delete");
        Product product = productService.findById(id);
        modelAndView.addObject("product", product);
        return  modelAndView;
    }

    @PostMapping("/confirm")
    public String deleteProduct(Product product) {
        productService.delete(product.getProductId());
        return "redirect:/products";
    }

    @GetMapping("/search")
    public String searchByName(Model model,@RequestParam("input") String input, @PageableDefault(value = 5) Pageable pageable) {
        model.addAttribute("productList",productService.searchByName(input, pageable));
        model.addAttribute("mode", "display");
        return "product/product-list";
    }

    @GetMapping("/delete-in-batch")
    public String showDeleteInBatchForm(Model model) {
        model.addAttribute("productList", productService.findAll());
        return "/product/product-delete-in-batch";
    }

    @PostMapping("/confirm-in-batch")
    public String deleteProductInBatch(@RequestParam(value = "deleteInBatch", required = false) List<Long> deleteInBatch, Model model) {
        if (deleteInBatch == null) {
            model.addAttribute("message", "Please choose product!!!");
            model.addAttribute("productList", productService.findAll());
            return "/product/product-delete-in-batch";
        } else {
            productService.deleteProductInBatch(deleteInBatch);
            return "redirect:/products";
        }
    }
}
