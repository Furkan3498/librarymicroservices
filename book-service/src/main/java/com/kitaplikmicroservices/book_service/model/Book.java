package com.kitaplikmicroservices.book_service.model;


import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private String id;
    private String title;
    private String bookYear;
    private String author;
    private String pressName;
    private String isbn;

    public Book() {
    }

    public Book(String id, String title, String bookYear, String author, String pressName, String isbn) {
        this.id = id;
        this.title = title;
        this.bookYear = bookYear;
        this.author = author;
        this.pressName = pressName;
        this.isbn = isbn;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBookYear() {
        return bookYear;
    }

    public void setBookYear(String bookYear) {
        this.bookYear = bookYear;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPressName() {
        return pressName;
    }

    public void setPressName(String pressName) {
        this.pressName = pressName;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", bookYear='" + bookYear + '\'' +
                ", author='" + author + '\'' +
                ", pressName='" + pressName + '\'' +
                ", isbn='" + isbn + '\'' +
                '}';
    }
}
