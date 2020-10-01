package vn.codegym.service;

import vn.codegym.model.Book;

public interface BookService {
    Iterable<Book> findAll();

    Book findById(int id);

    void save(Book book);

    void  delete(int id);
}
