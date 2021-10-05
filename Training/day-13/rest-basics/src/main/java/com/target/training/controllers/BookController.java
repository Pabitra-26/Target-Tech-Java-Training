package com.target.training.controllers;

import com.target.training.BookService;
import com.target.training.entity.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class BookController {
//    public BookController(){
//        log.info("BookController instantiated.");
//    }
    @Autowired
    BookService service;

    @GetMapping("/api/books")
    public Iterable<Book> handleBooks(){
//        BookService service = new BookService();
//        return "books details not available yet.";
        return service.getAllBooks();
    }
//
    @GetMapping("/api/books/{id}")
    public Book handleGetBookById(@PathVariable Integer id){
        return service.getBookById(id);
    }
}
