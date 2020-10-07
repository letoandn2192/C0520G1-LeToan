package vn.codegym.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.Blog;
import vn.codegym.model.Category;


public interface BlogRepository extends JpaRepository<Blog, Integer> {
    Page<Blog> findBlogByBlogTitleContaining (String name, Pageable pageable);

    Iterable<Blog> findBlogByBlogCategory (Category category);
}
