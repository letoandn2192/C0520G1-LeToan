package vn.codegym.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.model.Blog;
import vn.codegym.model.Category;

import java.util.List;

public interface BlogService {
    Page<Blog> findAll(Pageable pageable);

    Blog findById(int id);

    void save(Blog blog);

    void delete(int id);

    Page<Blog> findByTitle(String name, Pageable pageable);

    Iterable<Blog> findByCategory(Category category);
}
