package vn.codegym.model;

import javax.persistence.*;

@Entity
@Table
public class RandomCode {
    @Id
    private int randomCode;

    @ManyToOne
    @JoinColumn(name = "bookId")
    private Book book;

    public RandomCode() {
    }

    public RandomCode(int randomCode) {
        this.randomCode = randomCode;
    }

    public RandomCode(int randomCode, Book book) {
        this.randomCode = randomCode;
        this.book = book;
    }

    public int getRandomCode() {
        return randomCode;
    }

    public void setRandomCode(int randomCode) {
        this.randomCode = randomCode;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
