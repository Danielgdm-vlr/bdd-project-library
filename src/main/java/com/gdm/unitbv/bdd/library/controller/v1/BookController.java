package com.gdm.unitbv.bdd.library.controller.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gdm.unitbv.bdd.library.domain.entity.Book;
import com.gdm.unitbv.bdd.library.service.BookService;

import java.util.List;

@RestController
@RequestMapping("api/v1/book")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService){

        this.bookService = bookService;
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
