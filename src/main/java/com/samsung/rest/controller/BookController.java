package com.samsung.rest.controller;

import com.samsung.domain.Book;
import com.samsung.rest.dto.BookDto;
import com.samsung.service.BookSevice;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class BookController {

    private final BookSevice bookSevice;

    @GetMapping("/book")
    public List<BookDto> getAll() {
        return bookSevice.getAll()
                .stream()
                .map(BookDto::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/book")
    public BookDto insertBook(@RequestParam String nameBook,
                              @RequestParam String nameAuthor,
                              @RequestParam String nameGenre) {
        Book book = bookSevice.insert(nameBook, nameAuthor, nameGenre);
        return BookDto.toDto(book);
    }

    @PutMapping("/book/{id}")
    public BookDto updateBook(@PathVariable int id,
                              @RequestParam String nameBook,
                              @RequestParam String nameAuthor,
                              @RequestParam String nameGenre) {
        Book book = bookSevice.update(id, nameBook, nameAuthor, nameGenre);
        return BookDto.toDto(book);
    }

    @DeleteMapping("/book/{id}")
    public void deleteBook(@PathVariable int id) {
        bookSevice.deleteById(id);
    }

    @GetMapping("/book/{id}")
    public BookDto getBookId(@PathVariable int id) {
        Book book = bookSevice.getById(id);
        return BookDto.toDto(book);
    }

    @GetMapping("/book/name")
    public List<BookDto> getBookByName(@RequestParam String name) {

        return bookSevice.getByName(name).stream().map(BookDto::toDto).collect(Collectors.toList());
    }
}
