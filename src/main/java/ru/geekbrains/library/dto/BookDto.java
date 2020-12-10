package ru.geekbrains.library.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geekbrains.library.entites.Book;

@Data
@NoArgsConstructor
@ApiModel(description = "Product dto in the application.")
public class BookDto {
    @ApiModelProperty(notes = "Unique identifier of the book. No two books can have the same id.", example = "1", required = true, position = 0)
    private Long id;

    @ApiModelProperty(notes = "Title of the book.", example = "Harry Potter", required = true, position = 1)
    private String title;

    @ApiModelProperty(notes = "Price of the book.", example = "1998", required = true, position = 2)
    private int year;

    @ApiModelProperty(notes = "Author name of the book.", example = "Rowling", required = true, position = 3)
    private String authorName;

    public BookDto(Book p) {
        this.id = p.getId();
        this.title = p.getTitle();
        this.year = p.getYear();
        this.authorName = p.getAuthor().getName();
    }
}
