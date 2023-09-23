CREATE DATABASE library;
USE library;

CREATE TABLE books (
  id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  book_name varchar(5000) not null ,
  book_category VARCHAR(1000) NOT NULL,
  book_author VARCHAR(500) NOT NULL,
  book_publisher VARCHAR(500) NOT NULL,
  edition long,
  added_date timestamp not null,
  added_by varchar(500) not null,
  updated_date timestamp not null,
  updated_by varchar(500) not null
);

select * from books;