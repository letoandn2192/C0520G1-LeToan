package vn.codegym.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import vn.codegym.model.Blog;
import vn.codegym.model.Category;
import vn.codegym.service.BlogService;
import vn.codegym.service.CategoryService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private CategoryService categoryService;

    @ModelAttribute("categories")
    public Iterable<Category> getCategoryList() {
        return categoryService.findAll();
    }

    @GetMapping()
    public ResponseEntity<List<Blog>> getBlogList() {
        List<Blog> blogList = (List<Blog>) blogService.findAll();
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Void> createNewBlog(@RequestBody Blog blog, UriComponentsBuilder builder) {
        blog.setBlogCreateDate(LocalDate.now());
        blog.setBlogCreateTime(LocalTime.now());
        blogService.save(blog);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/blog/{id}").buildAndExpand(blog.getBlogId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @GetMapping(value = "/view/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Blog> viewBlog(@PathVariable("id") int id) {
        Blog blog = blogService.findById(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    @PatchMapping(value = "/edit/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> editBlog(@RequestBody Blog blog, @PathVariable("id") int id) {
        Blog currentBlog = blogService.findById(id);
        if (currentBlog == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        blogService.save(blog);
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteBlog(@PathVariable("id") int id) {
        Blog blog = blogService.findById(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        blogService.delete(blog.getBlogId());
        return new ResponseEntity<>( HttpStatus.OK);
    }
}
