package vn.codegym.review.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vn.codegym.review.model.Product;
import vn.codegym.review.model.ProductUpdateField;
import vn.codegym.review.service.ProductService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public ModelAndView showListPage(@CookieValue(value = "idHistory", defaultValue = "-1") Long idHistory) {
        ModelAndView modelAndView = new ModelAndView("product/list");
        if (idHistory != -1) {
            modelAndView.addObject("historyProduct", productService.findById(idHistory));
        }
        modelAndView.addObject("productList", productService.findAll());
        return modelAndView;
    }

    @GetMapping("/detail/{id}")
    public ModelAndView showDetailPage(@PathVariable Long id, HttpServletResponse response) {
        Cookie cookie = new Cookie("idHistory", id.toString());
        cookie.setMaxAge(30 * 24 * 60 * 60);
        cookie.setPath("/");
        response.addCookie(cookie);
        return new ModelAndView("product/detail", "product", productService.findById(id));
    }

    @PostMapping(value = "/edit", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity editProduct(@RequestBody ProductUpdateField updateField){
        Product product = productService.findById(updateField.getId());
        if(product==null){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            product.setDescription(updateField.getContent());
//            switch (updateField.getField()){
//                case "description": product.setDescription(updateField.getContent());
//            }
            productService.save(product);
        }
        return new ResponseEntity(HttpStatus.OK);
    }

//
//    @GetMapping("/create")
//    public ModelAndView showCreatePage(){
//        return new ModelAndView("product/create", "product", new Product());
//    }
//
//    @PostMapping("/create")
//    public String createProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes){
//        productService.save(product);
//        redirectAttributes.addFlashAttribute("success","Create new product name: " + product.getName());
//        return "redirect:/product";
//    }
}
