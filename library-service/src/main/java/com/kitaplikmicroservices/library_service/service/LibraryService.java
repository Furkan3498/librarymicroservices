package com.kitaplikmicroservices.library_service.service;

import com.kitaplikmicroservices.library_service.controller.Library;
import com.kitaplikmicroservices.library_service.dto.LibraryDto;
import com.kitaplikmicroservices.library_service.exception.LibraryNotFoundException;
import com.kitaplikmicroservices.library_service.repository.LibraryRepository;
import org.springframework.stereotype.Service;

@Service
public class LibraryService {


    private final LibraryRepository libraryRepository;

    public LibraryService(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    public LibraryDto getAllBooksInLibraryByID(String id){
        Library  library = libraryRepository.findById(id)
                .orElseThrow(()-> new LibraryNotFoundException("Library could not found by Id" + id));

        return new LibraryDto(library.getId());
    }
}
