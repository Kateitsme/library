package ru.geekbrains.library.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.library.dto.BookDto;
import ru.geekbrains.library.entites.Book;
import ru.geekbrains.library.exceptions.ResourceNotFoundException;
import ru.geekbrains.library.service.BookService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/books")
@Api("Set of endpoints for books")
public class BookController {
    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    // 2. Пропишите REST контроллеры для этих сущностей (для http-методов GET/ *POST)
    @GetMapping
    @ApiOperation("Returns all books")
    public List<BookDto> getAllBooks(){
        return bookService.getAllBooks().stream().map(BookDto::new).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @ApiOperation("Returns a specific book by their identifier. 404 if does not exist.")
    public BookDto getBookById(@ApiParam("Id of the book to be obtained. Cannot be empty.") @PathVariable Long id) {
        Book p = bookService.getOneById(id).orElseThrow(() -> new ResourceNotFoundException("Unable to find book with id: " + id));
        return new BookDto(p);
    }

}
