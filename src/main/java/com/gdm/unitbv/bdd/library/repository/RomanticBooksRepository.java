package com.gdm.unitbv.bdd.library.repository;

import com.gdm.unitbv.bdd.library.domain.entity.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RomanticBooksRepository extends CrudRepository<Book, Integer> {
}
