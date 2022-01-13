package com.gdm.unitbv.bdd.library.controller.v1;

import com.gdm.unitbv.bdd.library.domain.entity.Book;
import com.gdm.unitbv.bdd.library.service.RomanticBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/book")
public class BookController {

    private final RomanticBooksService romanticBooksService;

    @Autowired
    public BookController(RomanticBooksService romanticBooksService){

        this.romanticBooksService = romanticBooksService;
    }

    @GetMapping
    public Iterable<Book> getAll(){

        return romanticBooksService.getAll();
    }
}
