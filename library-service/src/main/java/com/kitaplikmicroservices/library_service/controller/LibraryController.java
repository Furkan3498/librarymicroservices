package com.kitaplikmicroservices.library_service.controller;

import com.kitaplikmicroservices.library_service.dto.AddBookRequest;
import com.kitaplikmicroservices.library_service.dto.LibraryDto;
import com.kitaplikmicroservices.library_service.service.LibraryService;
import org.hibernate.cfg.Environment;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RefreshScope
@RequestMapping("/v1/library")
public class LibraryController {

    Logger logger = (Logger) LoggerFactory.getLogger(LibraryController.class);
    private final LibraryService libraryService;


    @Value("${library-service.book.count}")
    private String count;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;

    }

    @GetMapping("{id}")
    public ResponseEntity<LibraryDto> getLibraryById(@PathVariable String id) {
        return ResponseEntity.ok(libraryService.getAllBooksInLibraryByID(id));
    }

    @PostMapping
    public ResponseEntity<LibraryDto> createLibrary() {
        logger.info("Library created on port number "  );

        return ResponseEntity.ok(libraryService.createLibrary());
    }





    @GetMapping("/count")
    public ResponseEntity<String> getCount() {
        return ResponseEntity.ok("Library count is" + count);
    }

}