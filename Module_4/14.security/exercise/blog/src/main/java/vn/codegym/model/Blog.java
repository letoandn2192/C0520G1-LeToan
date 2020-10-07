package vn.codegym.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int blogId;
    private String blogTitle;
    private String blogContent;
    private LocalDate blogCreateDate;
    private LocalTime blogCreateTime;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category blogCategory;

    public Blog() {
    }

    public Blog(String blogTitle, String blogContent, Category blogCategory) {
        this.blogTitle = blogTitle;
        this.blogContent = blogContent;
        this.blogCategory = blogCategory;
    }

    public int getBlogId() {
        return blogId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getBlogContent() {
        return blogContent;
    }

    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent;
    }

    public LocalDate getBlogCreateDate() {
        return blogCreateDate;
    }

    public void setBlogCreateDate(LocalDate blogCreateDate) {
        this.blogCreateDate = blogCreateDate;
    }

    public LocalTime getBlogCreateTime() {
        return blogCreateTime;
    }

    public void setBlogCreateTime(LocalTime blogCreateTime) {
        this.blogCreateTime = blogCreateTime;
    }

    public Category getBlogCategory() {
        return blogCategory;
    }

    public void setBlogCategory(Category blogCategory) {
        this.blogCategory = blogCategory;
    }
}
