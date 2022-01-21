package com.gdm.unitbv.bdd.library.service;

import com.gdm.unitbv.bdd.library.domain.entity.Book;
import com.gdm.unitbv.bdd.library.repository.romantic.RomanticBooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class RomanticBooksService {

    private final RomanticBooksRepository romanticBooksRepository;

    @Autowired
    public RomanticBooksService(RomanticBooksRepository romanticBooksRepository){

        this.romanticBooksRepository = romanticBooksRepository;
    }

    public List<Book> getAll(){

        return (List<Book>) romanticBooksRepository.findAll();
    }

    public Book saveOrUpdate(Book book){

        return romanticBooksRepository.save(book);
    }

    public Book getById(int id){

        AtomicReference<Book> bookAtomicReference = new AtomicReference<>();
        romanticBooksRepository.findById(id).ifPresent(bookAtomicReference::set);
        return bookAtomicReference.get();
    }
}
