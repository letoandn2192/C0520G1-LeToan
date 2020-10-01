package vn.codegym.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import vn.codegym.exception.BookException;
import vn.codegym.model.Book;
import vn.codegym.model.RandomCode;
import vn.codegym.service.BookService;
import vn.codegym.service.RandomCodeService;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private RandomCodeService randomCodeService;

    @GetMapping("")
    public String showBookList(Model model) {
        model.addAttribute("bookList", bookService.findAll());
        return "book/list";
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("book/create");
        modelAndView.addObject("book", new Book());
        return modelAndView;
    }

    @PostMapping("/save")
    public String saveBook(Book book) {
        book.setBookRest(book.getBookTotal());
        bookService.save(book);
        return "redirect: ";
    }

    @GetMapping("/view/{id}")
    public ModelAndView showViewForm(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView("book/view");
        modelAndView.addObject("book", bookService.findById(id));
        return modelAndView;
    }

    @PostMapping("/borrow")
    public ModelAndView borrowBook(Book book) {
        if (book.getBookRest() - 1 < 0) {
            throw new BookException();
        } else {
            book.setBookRest(book.getBookRest() - 1);
        }
        RandomCode randomCode = new RandomCode((int) Math.floor(Math.random() * 8999) + 10000, book);
        randomCodeService.save(randomCode);
        bookService.save(book);
        ModelAndView modelAndView = new ModelAndView("book/list");
        modelAndView.addObject("code", randomCode.getRandomCode());
        modelAndView.addObject("bookList", bookService.findAll());
        return modelAndView;
    }

    @GetMapping("/return")
    public ModelAndView returnBookForm(Book book) {
        return new ModelAndView("book/return", "book", book);
    }

    @PostMapping("/confirm")
    public String returnBook(Book book, @RequestParam("code") int code) {
        RandomCode randomCode = randomCodeService.findByBookAndCode(book.getBookId(), code);
        if (randomCode != null) {
            randomCodeService.delete(code);
            book.setBookRest(book.getBookRest() + 1);
            bookService.save(book);
        } else {
            return "book/error";
        }
        return "redirect:";
    }
}
