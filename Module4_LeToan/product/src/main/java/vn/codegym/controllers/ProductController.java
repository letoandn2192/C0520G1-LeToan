package vn.codegym.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.model.Category;
import vn.codegym.model.Product;
import vn.codegym.service.CategoryService;
import vn.codegym.service.ProductService;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @ModelAttribute("categoryList")
    public List<Category> getCategoryList() {
        return categoryService.findAll();
    }

    @GetMapping
    public String getProductList (Model model, @PageableDefault(value = 5) Pageable pageable, @RequestParam(value = "inputSearch", defaultValue = "") String inputSearch
                                    , @RequestParam(value = "select", defaultValue = "") String select) {
        Page<Product> productList;
        if ("".equals(inputSearch)) {
            productList = productService.findAll(pageable);
        } else {
//            productList = productService.findProductColorOrName(inputSearch, pageable);
            productList = findByField(inputSearch, select, pageable);
        }
        model.addAttribute("productList", productList);
        model.addAttribute("inputSearch", inputSearch);
        model.addAttribute("mode", "read");
        model.addAttribute("select", select);
        return "product/product-list";
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/product/product-create");
        modelAndView.addObject("product", new Product());
        return  modelAndView;
    }

    @PostMapping("/save")
    public String saveNewProduct(@Validated Product product, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "product/product-create";
        } else {
            productService.save(product);
            redirectAttributes.addFlashAttribute("messInform", "Create Successful!!!");
            return "redirect:/product";
        }
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
    public String editProduct(@Validated Product product, BindingResult bindingResult, Model model, @RequestParam("page") int page) {
        Pageable pageable = PageRequest.of(page, 5);
        model.addAttribute("productList", productService.findAll(pageable));
        if (bindingResult.hasErrors()) {
            model.addAttribute("mode", "edit");
        } else {
            productService.save(product);
            model.addAttribute("mode", "read");
            model.addAttribute("messInform", "Edit Successful!!!");
//            return "redirect:/product";
        }
        return "product/product-list";
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
        return "redirect:/product";
    }

//    @RequestMapping("/")
//    public String listCustomer(Model model,
//                               @RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
//                               @RequestParam(name = "size", required = false, defaultValue = "5") Integer size,
//                               @RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort) {
//        Sort sortable = null;
//        if (sort.equals("ASC")) {
//            sortable = Sort.by("id").ascending();
//        }
//        if (sort.equals("DESC")) {
//            sortable = Sort.by("id").descending();
//        }
//        Pageable pageable = PageRequest.of(page, size, sortable);
//
//        model.addAttribute("listCustomer", customerRepository.findCustomers(pageable));
//        return "customer-list";
//    }

    private Page<Product> findByField (String input, String field, Pageable pageable) {
        Page<Product> productList = null;
        switch (field) {
            case "id":
                productList = productService.findById(Long.parseLong(input), pageable);
                break;
            case "name":
                productList = productService.findByName(input, pageable);
                break;
            case "price":
                productList = productService.findByQuantity(Long.parseLong(input), pageable);
                break;
            case "quantity":
                productList = productService.findByQuantity(Long.parseLong(input), pageable);
                break;
            case "color":
                productList = productService.findByColor(input, pageable);
                break;
            case "category":
                productList = productService.findByCategoryName(input, pageable);
                break;
            default:
                productList = productService.findAll(pageable);
        }
        return productList;
    }
}
