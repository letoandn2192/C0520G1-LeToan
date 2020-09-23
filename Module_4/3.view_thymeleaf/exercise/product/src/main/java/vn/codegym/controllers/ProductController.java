package vn.codegym.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.model.Product;
import vn.codegym.service.ProductService;
import vn.codegym.service.ProductServiceImpl;

@Controller
public class ProductController {
    private ProductService productService = new ProductServiceImpl();

    @GetMapping("")
    public String getProductList(Model model) {
        model.addAttribute("productList", productService.findAll());
        return "list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("productType", productService.getProductType());
        return "create";
    }

    @PostMapping("/save")
    public String save(Product product, RedirectAttributes redirect) {
        productService.save(product);
        redirect.addFlashAttribute("mess", "Saved product successfully!");
        return "redirect:/";
    }

    @GetMapping("{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        model.addAttribute("productType", productService.getProductType());
        return "edit";
    }

    @PostMapping("/update")
    public String update(Product product, RedirectAttributes redirect) {
        productService.update(product.getProductId(), product);
        redirect.addFlashAttribute("mess", "Modified customer successfully!");
        return "redirect:/";
    }

    @GetMapping("{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "delete";
    }

    @PostMapping("/delete")
    public String delete(Product product, RedirectAttributes redirect) {
        productService.remove(product.getProductId());
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/";
    }
}
