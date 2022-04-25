package com.samsung.repository;

import com.samsung.domain.Book;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    @Override
    @EntityGraph(attributePaths = {"author", "genre", "commentList"}) // делаем меньше запросов к бд (объединяем все в одну бд), решение проблемы (n+1)
    List<Book> findAll();

    List<Book> findByName(String name);
}
