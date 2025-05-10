package com.kitaplikmicroservices.book_service.repository;

import com.kitaplikmicroservices.book_service.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepository extends JpaRepository<Book,String> {
}
