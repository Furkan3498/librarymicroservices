package com.kitaplikmicroservices.book_service.service;


import com.kitaplikmicroservices.book_service.dto.BookDto;
import com.kitaplikmicroservices.book_service.dto.BookIdDto;
import com.kitaplikmicroservices.book_service.exception.BookNotFoundException;
import com.kitaplikmicroservices.book_service.model.Book;
import com.kitaplikmicroservices.book_service.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookRepository bookRepository;


    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookDto> getAllBooks(){

      return bookRepository.findAll()
                .stream()
                .map(BookDto::bookDtos )
                .collect(Collectors.toList());


       /*   other option
       List<Book> bookList =bookRepository.findAll();
        List<BookDto> bookDtoList = new ArrayList<>();
        for (Book book :bookList){
            BookDto bookDto = new BookDto();
            bookDto.setTitle(book.getTitle());
            bookDto.setBookYear(book.getBookYear());
            bookDtoList.add(bookDto);

        }
        return bookDtoList;*/
    }

    public BookIdDto findByIsbn(String isbn){
        return bookRepository.findBookByIsbn(isbn)
                .map(book -> new BookIdDto(book.getId(),book.getIsbn()))
                .orElseThrow(() -> new BookNotFoundException("Book could not found by isbn :" + isbn));
    }

    public BookDto findBookDetailsById(String id){
        return bookRepository.findById(id)
                .map(BookDto::bookDtos).orElseThrow(() -> new BookNotFoundException("Book could not found by id : " +id));
    }
}
