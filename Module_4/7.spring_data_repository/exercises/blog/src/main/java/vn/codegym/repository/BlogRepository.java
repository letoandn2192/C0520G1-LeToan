package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.Blog;
import vn.codegym.model.Category;

public interface BlogRepository extends JpaRepository<Blog, Integer> {
    Iterable<Blog> findBlogByBlogTitleContaining (String name);

    Iterable<Blog> findBlogByBlogCategory (Category category);
}
