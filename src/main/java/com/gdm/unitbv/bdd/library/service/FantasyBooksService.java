package com.gdm.unitbv.bdd.library.service;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdm.unitbv.bdd.library.domain.entity.Book;
import com.gdm.unitbv.bdd.library.repository.fantasy.FantasyBooksRepository;

@Service
public class FantasyBooksService {

    private final FantasyBooksRepository fantasyBooksRepository;

    @Autowired
    public FantasyBooksService(FantasyBooksRepository fantasyBooksRepository) {

        this.fantasyBooksRepository = fantasyBooksRepository;
    }

    public List<Book> getAll() {

        return (List<Book>) fantasyBooksRepository.findAll();
    }

    public Book saveOrUpdate(Book book) {

        return fantasyBooksRepository.save(book);
    }

    public Book getById(int id) {

        AtomicReference<Book> bookAtomicReference = new AtomicReference<>();
        fantasyBooksRepository.findById(id).ifPresent(bookAtomicReference::set);
        return bookAtomicReference.get();
    }
}
