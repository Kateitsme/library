package ru.geekbrains.library.controllers;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.library.dto.AuthorCountBooksDto;
import ru.geekbrains.library.dto.AuthorDto;
import ru.geekbrains.library.dto.BookDto;
import ru.geekbrains.library.entites.Author;
import ru.geekbrains.library.exceptions.LibraryError;
import ru.geekbrains.library.exceptions.ResourceNotFoundException;
import ru.geekbrains.library.service.AuthorService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/authors")
public class AuthorController {
    private AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    @ApiOperation("Returns all books")
    public List<AuthorCountBooksDto> getAllBooks() {
        return authorService.getAllAuthors().stream().map(AuthorCountBooksDto::new).collect(Collectors.toList());
    }
    // 2. Пропишите REST контроллеры для этих сущностей (для http-методов GET/ *POST)
    @PostMapping
    @ApiOperation("Creates a new author. If id != null, then throw bad request response")
    public ResponseEntity<?> createNewAuthor(@RequestBody Author p) {
        if (p.getId() != null) {
            return new ResponseEntity<>(new LibraryError(HttpStatus.BAD_REQUEST.value(), "Id must be null for new entity"), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(authorService.save(p), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public AuthorDto getAuthorById(@PathVariable Long id) {
        Author author = authorService.getOneById(id).orElseThrow(() -> new ResourceNotFoundException("Unable to find category with id: " + id));
        return new AuthorDto(author);
    }
    // 3. Через REST API дайте возможность запрашивать автора по id со следующей структурой:
    // {
    //   "id": ...,
    //   "name": ...,
    //   "booksCount": ... // количество написанных книг
    // }
    @GetMapping("/{id}/count")
    public AuthorCountBooksDto getCountBooksById(@PathVariable Long id) {
        Author author = authorService.getOneById(id).orElseThrow(() -> new ResourceNotFoundException("Unable to find category with id: " + id));
        return new AuthorCountBooksDto(author);
    }
}
