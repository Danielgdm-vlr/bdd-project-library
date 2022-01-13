package com.gdm.unitbv.bdd.library.service;

import com.gdm.unitbv.bdd.library.domain.entity.Book;
import com.gdm.unitbv.bdd.library.repository.RomanticBooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RomanticBooksService {
    private final RomanticBooksRepository romanticBooksRepository;

    @Autowired
    public RomanticBooksService(RomanticBooksRepository romanticBooksRepository){

        this.romanticBooksRepository = romanticBooksRepository;
    }

    public Iterable<Book> getAll(){

        return romanticBooksRepository.findAll();
    }

    public Book saveOrUpdate(Book book){

        return romanticBooksRepository.save(book);
    }
}
