package vn.codegym.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;
    private String categoryName;

    @OneToMany(targetEntity = Blog.class)
    private List<Blog> CategoryBlogList;

    public Category() {
    }

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Blog> getCategoryBlogList() {
        return CategoryBlogList;
    }

    public void setCategoryBlogList(List<Blog> categoryBlogList) {
        CategoryBlogList = categoryBlogList;
    }
}
