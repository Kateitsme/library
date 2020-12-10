package ru.geekbrains.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.library.repositories.BookRepository;
import ru.geekbrains.library.entites.Book;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getOneById(Long id) {
        return bookRepository.findById(id);
    }

    public Book save(Book product) {
        return bookRepository.save(product);
    }
}
