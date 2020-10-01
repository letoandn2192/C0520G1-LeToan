package vn.codegym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.model.Book;
import vn.codegym.model.RandomCode;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
