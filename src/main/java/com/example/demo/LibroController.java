package com.example.demo;

import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
class LibroController {

    private final LibroRepository repository;

    LibroController(LibroRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/libros")
    List<Libro> all() {
        return repository.findAll();
    }

    @PostMapping("/libros")
    Libro newBook(@RequestBody Libro newLibro) {
        return repository.save(newLibro);
    }

    @GetMapping("/libros/{id}")
    Libro one(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new LibroNotFoundException(id));
    }

    @PutMapping("/libros/{id}")
    Libro replaceLibro(@RequestBody Libro newLibro, @PathVariable Long id) {
        return repository.findById(id)
                .map(libro -> {
                    libro.setTitulo(newLibro.getTitulo());
                    libro.setAutor(newLibro.getAutor());
                    libro.setIsbn(newLibro.getIsbn());
                    libro.setDisponible(newLibro.isDisponible());
                    return repository.save(libro);
                })
                .orElseGet(() -> {
                    newLibro.setId(id);
                    return repository.save(newLibro);
                });
    }

    @DeleteMapping("/libros/{id}")
    void deleteLibro(@PathVariable Long id) {
        repository.deleteById(id);
    }
}