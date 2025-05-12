package com.kitaplikmicroservices.library_service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class LibraryNotFoundException extends RuntimeException{

    public LibraryNotFoundException(String e ){
        super(e);
    }
}
