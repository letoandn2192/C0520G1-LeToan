package vn.codegym.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Book {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private int bookId;
    private String bookName;
    private String bookCategory;
    private int bookTotal;
    private int bookRest;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<RandomCode> codeList;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(String bookCategory) {
        this.bookCategory = bookCategory;
    }

    public int getBookTotal() {
        return bookTotal;
    }

    public void setBookTotal(int bookTotal) {
        this.bookTotal = bookTotal;
    }

    public int getBookRest() {
        return bookRest;
    }

    public void setBookRest(int bookRest) {
        this.bookRest = bookRest;
    }

    public List<RandomCode> getCodeList() {
        return codeList;
    }

    public void setCodeList(List<RandomCode> codeList) {
        this.codeList = codeList;
    }
}
