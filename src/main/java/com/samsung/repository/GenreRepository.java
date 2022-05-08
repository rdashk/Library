package com.samsung.repository;

import com.samsung.domain.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Integer> {

    // SELECT * FROM genre WHERE name = ?
    Genre findByName(String name);
}
