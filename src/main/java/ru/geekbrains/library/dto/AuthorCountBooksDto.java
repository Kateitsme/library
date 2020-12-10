package ru.geekbrains.library.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geekbrains.library.entites.Author;

@NoArgsConstructor
@Data

public class AuthorCountBooksDto {
    private Long id;
    private String name;
    private int books;

    public AuthorCountBooksDto(Author c) {
        this.id = c.getId();
        this.name = c.getName();
        this.books = c.getBooks().size();
    }
}
