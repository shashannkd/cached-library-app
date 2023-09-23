package com.shashannkd.libraryapp.repository;


import com.shashannkd.libraryapp.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryRepository extends JpaRepository<Book, Integer> {

    Book findBookByBookNameAndBookAuthorAndBookEdition(String bookName, String bookAuthor, long bookEdition);


}
