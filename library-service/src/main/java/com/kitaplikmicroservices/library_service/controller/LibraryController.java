package com.kitaplikmicroservices.library_service.controller;

import com.kitaplikmicroservices.library_service.dto.AddBookRequest;
import com.kitaplikmicroservices.library_service.dto.LibraryDto;
import com.kitaplikmicroservices.library_service.service.LibraryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RefreshScope
@RequestMapping("/v1/library")
public class LibraryController {

    Logger logger = LoggerFactory.getLogger(LibraryController.class);
    private final LibraryService libraryService;
    private final Environment environment;


    public LibraryController(LibraryService libraryService, Environment environment) {
        this.libraryService = libraryService;

        this.environment = environment;
    }

    @GetMapping("{id}")
    public ResponseEntity<LibraryDto> getLibraryById(@PathVariable String id) {
        return ResponseEntity.ok(libraryService.getAllBooksInLibraryByID(id));
    }

    @PostMapping
    public ResponseEntity<LibraryDto> createLibrary() {


        return ResponseEntity.ok(libraryService.createLibrary());
    }



    @PutMapping
    public ResponseEntity<Void> addToLibrary(@RequestBody AddBookRequest addBookRequest){
        libraryService.addBookToLibrary(addBookRequest);
        return ResponseEntity.ok().build();

    }





}