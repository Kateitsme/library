package ru.geekbrains.library.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionsControllerAdvice {
    @ExceptionHandler
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException e) {
        LibraryError libraryError = new LibraryError(HttpStatus.NOT_FOUND.value(), e.getMessage());
        return new ResponseEntity<>(libraryError, HttpStatus.NOT_FOUND);
    }
}

