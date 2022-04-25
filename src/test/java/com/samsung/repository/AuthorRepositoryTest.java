package com.samsung.repository;

import com.samsung.domain.Author;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class AuthorRepositoryTest {

    public static final int EXISTING_AUTHOR_COUNT = 3;
    public static final int EXISTING_ID1 = 1;
    public static final String EXISTING_NAME1 = "Имя автора 1";
    public static final int EXISTING_ID2 = 2;
    public static final int EXISTING_ID3 = 3;
    public static final String EXISTING_NAME2 = "Имя автора 3";
    public static final String EXISTING_NAME3 = "Гарри Гаррисон";

   @Autowired
    private AuthorRepository authorRepository;

   @PersistenceContext
   private EntityManager entityManager;

    @DisplayName("должен добавлять автора")
    @Test
    void shouldInsertAuthor() {
        Author expectedAuthor = Author.builder()
                .id(4)
                .name("Ivan")
                .build();

        authorRepository.save(expectedAuthor);
        Author actualAuthor = authorRepository.getById(4);

        assertThat(actualAuthor).isEqualTo(expectedAuthor);
    }

    @DisplayName("должен удалять автора по id")
    @Test
    void shouldDeleteAuthorById() {

        int sizeBefore = authorRepository.findAll().size();

        authorRepository.deleteById(1);
        entityManager.flush();

        int sizeAfter = authorRepository.findAll().size();
        assertThat(sizeBefore).isEqualTo(sizeAfter + 1);
    }
}