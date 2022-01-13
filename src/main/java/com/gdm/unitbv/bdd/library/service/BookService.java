package com.gdm.unitbv.bdd.library.service;

import com.gdm.unitbv.bdd.library.domain.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private final RomanticBooksService romanticBooksService;
    private final RealistBooksService realistBooksService;
    private final FantasyBooksService fantasyBooksService;

    @Autowired
    public BookService(RomanticBooksService romanticBooksService,
                          RealistBooksService realistBooksService,
                          FantasyBooksService fantasyBooksService){

        this.romanticBooksService = romanticBooksService;
        this.realistBooksService = realistBooksService;
        this.fantasyBooksService = fantasyBooksService;
    }


    public List<Book> getAll(){

        List<Book> bookList = new ArrayList<>();
        bookList.addAll(romanticBooksService.getAll());
        bookList.addAll(realistBooksService.getAll());
        bookList.addAll(fantasyBooksService.getAll());

        return bookList;
    }

    public Book saveOrUpdate(Book book){

        switch (book.getGenre()){
            case ROMANTIC:
                return romanticBooksService.saveOrUpdate(book);
            case REALIST:
                return realistBooksService.saveOrUpdate(book);
            case FANTASY:
                return fantasyBooksService.saveOrUpdate(book);
            default:
                return null;
        }
    }
}
