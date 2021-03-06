package com.gdm.unitbv.bdd.library.repository.fantasy;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gdm.unitbv.bdd.library.domain.entity.Book;

@Repository
public interface FantasyBooksRepository extends CrudRepository<Book, Integer> {
}
