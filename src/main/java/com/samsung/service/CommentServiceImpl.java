package com.samsung.service;

import com.samsung.domain.Book;
import com.samsung.domain.Comment;
import com.samsung.repository.BookRepository;
import com.samsung.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService{

    private final CommentRepository commentRepository;
    private final BookRepository bookRepository;

    @Override
    public Comment insert(String content, int bookId) {

        Book book = bookRepository.findById(bookId).orElse(null);
        Comment comment = Comment.builder()
                .content(content)
                .book(book)
                .build();
        return commentRepository.save(comment);
    }

    @Override
    public Comment getById(int id) {
        return commentRepository.getById(id);
    }

    @Override
    public List<Comment> getAll() {
        return commentRepository.findAll();
    }

    @Override
    public List<Comment> getByBookId(int bookId) {
        return commentRepository.findByBookId(bookId);
    }

    @Override
    public void deleteById(int id) {

        commentRepository.deleteById(id);
    }

    @Override
    public void update(int id, String content) {

        commentRepository.updateCommentById(id, content);
    }
}
