package dev.hunghh.springthreelayer.service;

import dev.hunghh.springthreelayer.entity.Book;
import dev.hunghh.springthreelayer.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    public Book save(Book book){
        return repository.saveAndFlush(book);
    }

    public Book findBook(int id){
        Book book = repository.findById(id);
        book.setPrice(book.getPrice() * 15);
        return book;
    }

    public List<Book> findAll(){
        return repository.findAll();
    }

    public Book update(Book book) {
        return repository.saveAndFlush(book);
    }

    public void delete(Book book){
        repository.delete(book);
    }
}
