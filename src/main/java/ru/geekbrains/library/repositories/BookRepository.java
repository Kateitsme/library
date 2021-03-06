package ru.geekbrains.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.library.entites.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
