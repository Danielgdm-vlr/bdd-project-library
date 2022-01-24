package com.gdm.unitbv.bdd.library.repository.romantic;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gdm.unitbv.bdd.library.domain.entity.Book;

@Repository
public interface RomanticBooksRepository extends CrudRepository<Book, Integer> {
}
