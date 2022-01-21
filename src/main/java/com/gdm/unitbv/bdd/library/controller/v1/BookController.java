package com.gdm.unitbv.bdd.library.controller.v1;

import com.gdm.unitbv.bdd.library.domain.entity.Book;
import com.gdm.unitbv.bdd.library.service.BookService;
import com.gdm.unitbv.bdd.library.service.FantasyBooksService;
import com.gdm.unitbv.bdd.library.service.RealistBooksService;
import com.gdm.unitbv.bdd.library.service.RomanticBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@RestController
@RequestMapping("api/v1/book")
public class BookController {

    private final BookService bookService;
    private final FantasyBooksService fantasyBooksService;
    private final RealistBooksService realistBooksService;
    private final RomanticBooksService romanticBooksService;

    @Autowired
    public BookController(BookService bookService,
                          FantasyBooksService fantasyBooksService,
                          RealistBooksService realistBooksService,
                          RomanticBooksService romanticBooksService){

        this.bookService = bookService;
        this.fantasyBooksService = fantasyBooksService;
        this.realistBooksService = realistBooksService;
        this.romanticBooksService = romanticBooksService;
    }

    @GetMapping
    public List<Book> getAll(){

        return bookService.getAll();
    }

    @PostMapping
    public Book saveOrUpdate(@RequestBody Book book){

        return bookService.saveOrUpdate(book);
    }

    @GetMapping("/id/genre")
    public Book getByIdAndGenre(@RequestParam int id, @RequestParam String genre) {

        return bookService.getByIdAndGenre(id, genre);
    }
}
