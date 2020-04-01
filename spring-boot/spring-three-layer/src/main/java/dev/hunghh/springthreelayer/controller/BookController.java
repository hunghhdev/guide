package dev.hunghh.springthreelayer.controller;

import dev.hunghh.springthreelayer.entity.Book;
import dev.hunghh.springthreelayer.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService service;

    @GetMapping
    public ResponseEntity<List<Book>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping
    public ResponseEntity<Book> findBook(@RequestParam int id) {
        if (id<0){
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok(service.findBook(id));
    }

    @PostMapping
    public ResponseEntity<Book> save(@RequestBody Book book) {
        return ResponseEntity.ok(service.save(book));
    }

    @PutMapping
    public ResponseEntity<Book> update(@RequestBody Book book) {
        return ResponseEntity.ok(service.update(book));
    }

    @DeleteMapping
    public void delete(@RequestBody Book book) {
        service.delete(book);
    }
}
