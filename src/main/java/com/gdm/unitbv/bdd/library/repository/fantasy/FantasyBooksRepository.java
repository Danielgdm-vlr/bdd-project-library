package com.gdm.unitbv.bdd.library.repository.fantasy;

import com.gdm.unitbv.bdd.library.domain.entity.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FantasyBooksRepository extends CrudRepository<Book, Integer> {
}
