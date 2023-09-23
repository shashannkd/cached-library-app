package com.shashannkd.libraryapp.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Table(name = "books")
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    public int id;
    public String bookName;
    public String bookAuthor;
    public String bookCategory;
    public String bookPublisher;
    @Column(name = "edition")
    public long bookEdition;
    public Date addedDate;
    public String addedBy;
    public Date updatedDate;
    public String updatedBy;

    public Book(String bookName, String bookAuthor, String bookCategory, String bookPublisher, long bookEdition, Date addedDate, String addedBy,
                Date updatedDate, String updatedBy) {
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookCategory = bookCategory;
        this.bookPublisher = bookPublisher;
        this.bookEdition = bookEdition;
        this.addedDate = addedDate;
        this.addedBy = addedBy;
        this.updatedDate = updatedDate;
        this.updatedBy = updatedBy;
    }

    public Book(int id, String bookName, String bookAuthor, String bookCategory, String bookPublisher, long bookEdition,
                Date addedDate, String addedBy, Date updatedDate, String updatedBy) {
        this.id = id;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookCategory = bookCategory;
        this.bookPublisher = bookPublisher;
        this.bookEdition = bookEdition;
        this.addedDate = addedDate;
        this.addedBy = addedBy;
        this.updatedDate = updatedDate;
        this.updatedBy = updatedBy;
    }

    public Book() {

    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookCategory='" + bookCategory + '\'' +
                ", bookPublisher='" + bookPublisher + '\'' +
                ", bookEdition=" + bookEdition +
                ", updatedDate=" + updatedDate +
                ", updatedBy='" + updatedBy + '\'' +
                ", addedDate=" + addedDate +
                ", addedBy='" + addedBy + '\'' +
                '}';
    }
}
