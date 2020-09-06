package com.restServer.Bookserver;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    private final BookRepository repository;

    public BookController(BookRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/books")
    List<Book> all() {
        return repository.findAll();
    }

    @PostMapping("/books")
    Book newBook(@RequestBody Book newBook) {
        return repository.save(newBook);
    }

    @GetMapping("/books/{id}")
    Book one(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(
                () -> new BookNotFoundException(id)
        );
    }

    @PutMapping("/books/{id}")
    Book replaceBook(@RequestBody Book newBook, @PathVariable Long id) {
        return repository.findById(id)
                .map(book -> {
                    book.setText(newBook.getText());
                    book.setText(newBook.getTitle());
                    return repository.save(book);
                })
                .orElseGet( () -> {
                    newBook.setId(id);
                    return repository.save(newBook);
                });
    }

    @DeleteMapping("/books/{id}")
    void deleteBook(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
