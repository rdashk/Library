package com.samsung.service;

import com.samsung.domain.Author;
import com.samsung.domain.Book;
import com.samsung.domain.Comment;
import com.samsung.repository.AuthorRepository;
import com.samsung.repository.BookRepository;
import com.samsung.repository.CommentRepository;
import liquibase.pro.packaged.B;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LibDemoService {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final CommentRepository commentRepository;

    public void authorDemo() {

        System.out.println("==========");
        List<Author> authorList = authorRepository.findAll();
        for (Author author: authorList) {
            System.out.println(author);
        }
        System.out.println("==========");

        Author author = Author.builder()
                .name("Иван")
                .build();

        authorRepository.save(author);

        System.out.println("==========");
        authorList = authorRepository.findAll();
        for (Author author1: authorList) {
            System.out.println(author1);
        }
        System.out.println("==========");

        System.out.println(authorRepository.findByName("Имя автора 1"));
    }

    @Transactional
    public void bookDemo() {

        /*List<Book> bookList = bookRepository.findAll();
        for (Book book: bookList) {
            System.out.println(book.getName() + ":");
            System.out.println(book.getAuthor().getName() + "," + book.getGenre().getName());

            List<Comment> commentList = book.getCommentList();
            for (Comment comment: commentList) {
                System.out.println(comment.getContent());
            }
        }*/
        List<Book> bookList1 = bookRepository.findByName("Название книги 3");
        for (Book book: bookList1) {
            System.out.println(book.getName() + ":");
            System.out.println(book.getAuthor().getName() + "," + book.getGenre().getName());

            List<Comment> commentList = book.getCommentList();
            for (Comment comment: commentList) {
                System.out.println(comment.getContent());
            }
        }

    }

    @Transactional
    public void commentDemo() {
        commentRepository.updateCommentById(1, "Новый комментарий 1");

        List<Comment> commentList = commentRepository.findAll();
        for (Comment comment: commentList) {
            System.out.println(comment.getId() + " - " + comment.getContent());
        }

        commentList = commentRepository.findByBookId(2);
        for (Comment comment: commentList) {
            System.out.println(comment.getId() + " - " + comment.getContent());
        }
    }
}
