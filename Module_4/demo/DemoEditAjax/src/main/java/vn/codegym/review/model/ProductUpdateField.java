package vn.codegym.review.model;

import org.springframework.stereotype.Component;

@Component
public class ProductUpdateField {
    private Long id;
    private String content;
    private String field;

    public ProductUpdateField() {
    }

    public ProductUpdateField(Long id, String content, String field) {
        this.id = id;
        this.content = content;
        this.field = field;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }
}
