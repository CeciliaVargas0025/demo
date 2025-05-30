package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
class LibroNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(LibroNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String libroNotFoundHandler(LibroNotFoundException ex) {
        return ex.getMessage();
    }
}