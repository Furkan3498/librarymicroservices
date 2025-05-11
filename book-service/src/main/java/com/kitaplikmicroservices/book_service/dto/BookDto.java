package com.kitaplikmicroservices.book_service.dto;

import com.kitaplikmicroservices.book_service.model.Book;

public class BookDto{


    private String id;
    private String title;
    private String bookYear;
    private String author;
    private String pressName;
    private String isbn;

    public BookDto() {
    }

    public  static BookDto bookDtos (Book book){

       BookDto  bookDto = new BookDto();
       bookDto.setId(book.getId());
       bookDto.setBookYear(book.getBookYear());
       bookDto.setAuthor(book.getAuthor());
       bookDto.setIsbn(book.getIsbn());
       bookDto.setPressName(book.getPressName());
       bookDto.setTitle(book.getTitle());
       return bookDto;
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


}
