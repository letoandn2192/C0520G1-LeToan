package vn.codegym.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.model.Blog;
import vn.codegym.model.Category;
import vn.codegym.repository.BlogRepository;
import vn.codegym.service.BlogService;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogRepository blogRepository;

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void delete(int id) {
        blogRepository.deleteById(id);
    }

    @Override
    public Iterable<Blog> findByTitle(String name) {
        return blogRepository.findBlogByBlogTitleContaining(name);
    }

    @Override
    public Iterable<Blog> findByCategory(Category category) {
        return blogRepository.findBlogByBlogCategory(category);
    }
}
