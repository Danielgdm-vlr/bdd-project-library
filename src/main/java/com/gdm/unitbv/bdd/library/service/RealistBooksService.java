package com.gdm.unitbv.bdd.library.service;

import com.gdm.unitbv.bdd.library.domain.entity.Book;
import com.gdm.unitbv.bdd.library.repository.realist.RealistBooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class RealistBooksService {

    private final RealistBooksRepository realistBooksRepository;

    @Autowired
    public RealistBooksService(RealistBooksRepository realistBooksRepository) {

        this.realistBooksRepository = realistBooksRepository;
    }

    public List<Book> getAll() {

        return (List<Book>) realistBooksRepository.findAll();
    }

    public Book saveOrUpdate(Book book) {

        return realistBooksRepository.save(book);
    }

    public Book getById(int id) {

        AtomicReference<Book> bookAtomicReference = new AtomicReference<>();
        realistBooksRepository.findById(id).ifPresent(bookAtomicReference::set);
        return bookAtomicReference.get();
    }
}
