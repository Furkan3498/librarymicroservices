package com.kitaplikmicroservices.library_service.client;


import com.kitaplikmicroservices.library_service.dto.BookDto;
import com.kitaplikmicroservices.library_service.dto.BookIdDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "book-service", path = "/v1/book")
public interface BookServiceClient {

    @GetMapping
      ResponseEntity<List<BookDto>> getAllBooks();

    @GetMapping("/isbn/{isbn}")
      ResponseEntity<BookIdDto> getBookByIsbn(@PathVariable   String isbn);

    @GetMapping("/book/{id}")
    public ResponseEntity<BookDto> getBookById(@PathVariable  String id);
}
