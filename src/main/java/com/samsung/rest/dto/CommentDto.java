package com.samsung.rest.dto;

import com.samsung.domain.Book;
import com.samsung.domain.Comment;
import liquibase.pro.packaged.S;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentDto {

    private int id;
    private String content;

    public static CommentDto toDto(Comment comment) {
        return new CommentDto(
                comment.getId(),
                comment.getContent()
        );
    }

    public static Comment toDomainObject(CommentDto commentDto, Book book) {

        return new Comment(
                commentDto.getId(),
                commentDto.getContent(),
                book
        );
    }
}
