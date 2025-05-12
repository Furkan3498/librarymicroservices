package com.kitaplikmicroservices.library_service.service;

import com.kitaplikmicroservices.library_service.client.BookServiceClient;
import com.kitaplikmicroservices.library_service.dto.AddBookRequest;
import com.kitaplikmicroservices.library_service.model.Library;
import com.kitaplikmicroservices.library_service.dto.LibraryDto;
import com.kitaplikmicroservices.library_service.exception.LibraryNotFoundException;
import com.kitaplikmicroservices.library_service.repository.LibraryRepository;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class LibraryService {


    private final LibraryRepository libraryRepository;
    private final BookServiceClient bookServiceClient;

    public LibraryService(LibraryRepository libraryRepository, BookServiceClient bookServiceClient) {
        this.libraryRepository = libraryRepository;
        this.bookServiceClient = bookServiceClient;
    }

    public LibraryDto getAllBooksInLibraryByID(String id){
        Library  library = libraryRepository.findById(id)
                .orElseThrow(()-> new LibraryNotFoundException("Library could not found by Id" + id));

        LibraryDto libraryDto=  new LibraryDto(library.getId(),
                library.getUserBook()
                        .stream()
                        .map(book-> bookServiceClient.getBookById(book).getBody())
                     //   .map(bookServiceClient::getBookById) //feign
                       // .map(ResponseEntity::getBody)
                        .collect(Collectors.toList()));
        return libraryDto;

    }

    public LibraryDto createLibrary(){
        Library newLibrary = libraryRepository.save(new Library());
        return new LibraryDto(newLibrary.getId());
    }

    public void addBookToLibrary(AddBookRequest addBookRequest){
        String book = bookServiceClient.getBookByIsbn(addBookRequest.getIsbn()).getBody().getBookId();

        Library library = libraryRepository.findById(addBookRequest.getId())
                .orElseThrow(()->new LibraryNotFoundException("Library could not found by Id" + addBookRequest.getId()));


        library.getUserBook()
                .add(book);

        libraryRepository.save(library);
    }
}
