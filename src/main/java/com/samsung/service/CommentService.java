package com.samsung.service;

import com.samsung.domain.Comment;

import java.util.List;

public interface CommentService {

    Comment insert(Comment comment);

    List<Comment> getAll();

    List<Comment> getByBookId(int bookId);

    void deleteById(int id);

    void update(int id, String content);
}
