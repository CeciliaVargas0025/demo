package com.example.demo;

class LibroNotFoundException extends RuntimeException {
    LibroNotFoundException(Long id) {
        super("Could not find libro " + id);
    }
}