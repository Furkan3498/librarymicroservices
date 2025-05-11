package com.kitaplikmicroservices.book_service.repository;

import com.kitaplikmicroservices.book_service.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface BookRepository extends JpaRepository<Book,String> {

    Optional<Book> findBookByIsbn(String isbn);
}
