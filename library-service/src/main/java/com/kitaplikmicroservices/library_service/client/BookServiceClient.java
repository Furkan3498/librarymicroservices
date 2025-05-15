package com.kitaplikmicroservices.library_service.client;


import com.kitaplikmicroservices.library_service.dto.BookDto;
import com.kitaplikmicroservices.library_service.dto.BookIdDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "book-service", path = "/v1/book")
public interface BookServiceClient {

    Logger logger = LoggerFactory.getLogger(BookServiceClient.class);

    @GetMapping("/isbn/{isbn}")
    @CircuitBreaker(name = "getBookByIsbnCircuitBreaker" , fallbackMethod = "getBookFallback")

    ResponseEntity<BookIdDto> getBookByIsbn(@PathVariable(value = "isbn") String isbn);

    //must be same name fallbackMethod
    //need same parameter and exception
    default ResponseEntity<BookIdDto> getBookFallback(String isbn ,Exception exception){
        // if user parameter fault we can log.info
        //else  error status 405 log.error

        logger.info("Book not found by isbn " + isbn + ", returning default BookDto object");
        return ResponseEntity.ok(new BookIdDto("default-book","default-isbn"));

    }


    @GetMapping("/book/{id}")
    public ResponseEntity<BookDto> getBookById(@PathVariable  String id);

    @GetMapping
    ResponseEntity<List<BookDto>> getAllBooks();
}
