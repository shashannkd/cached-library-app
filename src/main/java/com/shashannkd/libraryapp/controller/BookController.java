package com.shashannkd.libraryapp.controller;

import com.shashannkd.libraryapp.entity.Book;
import com.shashannkd.libraryapp.repository.LibraryRepository;
import com.shashannkd.libraryapp.service.impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    @Autowired
    BookServiceImpl bookService;

    @Autowired
    LibraryRepository repository;

    Logger logger = Logger.getLogger(this.getClass().getName());


    @GetMapping("/getAllBooks")
    @ResponseBody
    public List<Book> getAllBooks() {
        List<Book> booksList = bookService.getAllBooks();
        logger.info("Book info retrieved " + booksList.toString());
        return booksList;
    }

    @GetMapping("/getBookById")
    @Transactional(readOnly = true)
    public ResponseEntity<Book> getAllBooks(@RequestParam int id) {
        Book book = bookService.getBook(id);
        logger.info("Book info retrieved " + book);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @PostMapping("/saveBook")
    public ResponseEntity<String> saveBook(@RequestBody Book book) throws Exception {
        logger.info("adding book ");
        if(repository.findBookByBookNameAndBookAuthorAndBookEdition(book.bookName, book.bookAuthor, book.bookEdition) == null) {
            bookService.addBook(book);
            return new ResponseEntity<>(book.bookName+" added to DB",HttpStatus.CREATED);
        }
        return new ResponseEntity<>("This book is already present in the DB",HttpStatus.OK);
    }

    @PutMapping("/updateBook")
    public Book updateBook(@RequestBody Book book) {
        return bookService.updateBook(book);
    }

    @DeleteMapping("/removeBook/{id}")
    public Book removeBook(@PathVariable int id) {
        return bookService.deleteBook(id);
    }
}
