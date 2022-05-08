package com.samsung.service;

import com.samsung.domain.Author;
import com.samsung.domain.Book;
import com.samsung.domain.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LibDemoService {

    private final AuthorService authorService;
    private final BookSevice bookSevice;
    private final CommentService commentService;

    public void authorDemo() {

        System.out.println("==========");
        List<Author> authorList = authorService.getAll();
        for (Author author: authorList) {
            System.out.println(author);
        }
        System.out.println("==========");

        authorService.update(1, "Иван");

        System.out.println("==========");
        Author author = Author.builder()
                .name("My")
                .build();
        authorService.insert(author);
        authorList = authorService.getAll();
        for (Author author2: authorList) {
            System.out.println(author2);
        }

        System.out.println("==========");

        System.out.println(authorService.getByName("Имя автора 1"));
    }

    @Transactional
    public void bookDemo() {

        List<Book> bookList = bookSevice.getAll();
        for (Book book: bookList) {
            System.out.println(book.getName() + ":");
            System.out.println(book.getAuthor().getName() + "," + book.getGenre().getName());

            List<Comment> commentList = book.getCommentList();
            if (commentList != null) {
                for (Comment comment: commentList) {
                    System.out.println(comment.getContent());
                }
            }
        }
        System.out.println("==========");

        bookSevice.insert(
                "Название книги 4",
                "Имя автора 4",
                "Жанр 4");

        bookList = bookSevice.getAll();
        for (Book book: bookList) {
            System.out.println(book.getName() + ":");
            System.out.println(book.getAuthor().getName() + "," + book.getGenre().getName());

            List<Comment> commentList = book.getCommentList();
            if (commentList != null) {
                for (Comment comment: commentList) {
                    System.out.println(comment.getContent());
                }
            }
        }
    }

    @Transactional
    public void commentDemo() {
        commentService.update(1, "Новый комментарий 1");

        List<Comment> commentList = commentService.getAll();
        for (Comment comment: commentList) {
            System.out.println(comment.getId() + " - " + comment.getContent());
        }

        commentService.insert("Комментарий 5", 1);

        commentList = commentService.getByBookId(1);
        for (Comment comment: commentList) {
            System.out.println(comment.getId() + " - " + comment.getContent());
        }
    }
}
