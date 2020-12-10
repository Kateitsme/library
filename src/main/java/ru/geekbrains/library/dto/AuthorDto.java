package ru.geekbrains.library.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geekbrains.library.entites.Author;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Data
public class AuthorDto {
    private Long id;
    private String name;
    private List<BookDto> books;

    public AuthorDto(Author c) {
        this.id = c.getId();
        this.name = c.getName();
        this.books = c.getBooks().stream().map(BookDto::new).collect(Collectors.toList());
    }
}
