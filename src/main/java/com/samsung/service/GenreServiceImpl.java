package com.samsung.service;

import com.samsung.domain.Genre;
import com.samsung.repository.GenreRepository;
import liquibase.pro.packaged.G;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService{

    private GenreRepository genreRepository;

    @Override
    public Genre insert(Genre genre) {

        return genreRepository.save(genre);
    }

    @Override
    public List<Genre> getAll() {
        return genreRepository.findAll();
    }

    @Override
    public Genre getById(int id) {
        return genreRepository.getById(id);
    }

    @Override
    public Genre getByName(String name) {
        return genreRepository.findByName(name);
    }

    @Override
    public Genre update(int id, String genreName) {

        Genre genre = Genre.builder()
                .id(id)
                .name(genreName)
                .build();
        return genreRepository.save(genre);
    }

    @Override
    public void deleteById(int id) {

        genreRepository.deleteById(id);
    }
}
