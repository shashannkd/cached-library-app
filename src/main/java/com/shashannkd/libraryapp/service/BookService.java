package com.shashannkd.libraryapp.service;

import com.shashannkd.libraryapp.entity.Book;

import java.util.List;


public interface BookService {

    List<Book> getAllBooks();
    Book getBook(int id);

    void addBook(Book book) throws Exception;

    Book updateBook(Book book);

    Book deleteBook(int id);

}
