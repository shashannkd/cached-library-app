package com.shashannkd.libraryapp.service.impl;

import com.shashannkd.libraryapp.entity.Book;
import com.shashannkd.libraryapp.repository.LibraryRepository;
import com.shashannkd.libraryapp.service.BookService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;


@Service
public class BookServiceImpl implements BookService {

    Logger logger = Logger.getLogger(getClass().getName());
    LibraryRepository libraryRepository;

    public BookServiceImpl(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    @Override
    public List<Book> getAllBooks() {
        logger.info("getAllBooks");
        return libraryRepository.findAll();

    }

    @Override
    public Book getBook(int id) {
        Optional<Book> book = libraryRepository.findById(id);
        logger.info("Retrieved Book from DB " + book);
        return book.orElse(null);

    }

    @Override
    public void addBook(Book book) throws Exception {
        logger.info("book obj "+book);
        try {
            Book bookFromDB = libraryRepository.findBookByBookNameAndBookAuthorAndBookEdition(book.bookName, book.bookAuthor, book.bookEdition);
            if (bookFromDB == null) {
                book.updatedBy = "Shashannk";
                book.updatedDate=new Date();
                book.addedBy="Shashannk";
                book.addedDate=new Date();
                libraryRepository.save(book);
            }

        } catch (Exception e) {
            throw new Exception("Book with name " + book.bookName + "is already available");
        }
    }

    @Override
    public Book updateBook(Book book) {

        Optional<Book> bookOpt = libraryRepository.findById(book.id);

        if (bookOpt.isPresent()) {
            Book existingBook = bookOpt.get();

            // Update the user's fields with the new data
            existingBook.bookName = book.bookName;
            existingBook.bookAuthor = book.bookAuthor;
            existingBook.updatedBy = "Shashannk";
            existingBook.updatedDate = new Date();

            // Save the updated user
            return libraryRepository.save(existingBook);
        } else {
            logger.info("Update book failed " + book);
        }
        return getBook(book.id);
    }

    @Override
    public Book deleteBook(int id) {
        Book book = getBook(id);
        libraryRepository.deleteById(id);
        return book;
    }
}
