package com.kitaplikmicroservices.book_service.dto;

import com.kitaplikmicroservices.book_service.model.Book;

import java.util.Objects;

public class BookIdDto {

    private String id;
    private String isbn;


    public static BookIdDto bookDto (Book book){
        BookIdDto idDto = new BookIdDto();
        idDto.setId(book.getId());
        idDto.setIsbn(book.getIsbn());
        return idDto;
    }
    public BookIdDto() {
    }

    public BookIdDto(String id, String isbn) {
        this.id = id;
        this.isbn = isbn;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "BookIdDto{" +
                "id='" + id + '\'' +
                ", isbn='" + isbn + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookIdDto bookIdDto = (BookIdDto) o;
        return Objects.equals(id, bookIdDto.id) && Objects.equals(isbn, bookIdDto.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, isbn);
    }
}
