package com.restServer.Bookserver;


import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class BookController {

    private final BookRepository repository;
    private final BookModelAssembler assembler;

    public BookController(BookRepository repository, BookModelAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }

    @GetMapping("/books")
    CollectionModel<EntityModel<Book>> all() {

        List<EntityModel<Book>> books = repository.findAll().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(books,
                linkTo(methodOn(BookController.class).all()).withSelfRel());
    }

    @PostMapping("/books")
    Book newBook(@RequestBody Book newBook) {
        return repository.save(newBook);
    }

    @GetMapping("/books/{id}")
    EntityModel<Book> one(@PathVariable Long id) {
        Book book = repository.findById(id)
                .orElseThrow( () -> new BookNotFoundException(id));
        return assembler.toModel(book);
    }


    @PutMapping("/books/{id}")
    ResponseEntity<?> replaceBook(@RequestBody Book newBook, @PathVariable Long id) {
        Book updatedBook = repository.findById(id)
                .map(book -> {
                    book.setText(newBook.getText());
                    book.setText(newBook.getTitle());
                return repository.save(book);
                })
                .orElseGet( () -> {
                    newBook.setId(id);
                    return repository.save(newBook);
                });
        EntityModel<Book> entityModel = assembler.toModel(updatedBook);

        return ResponseEntity
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(entityModel);
    }

    @DeleteMapping("/books/{id}")
    ResponseEntity<?> deleteBook(@PathVariable Long id) {
        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
