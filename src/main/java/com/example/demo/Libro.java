package com.example.demo;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
class Libro {

    private @Id @GeneratedValue Long id;
    private String titulo;
    private String autor;
    private String isbn;
    private boolean disponible;

    Libro() {}

    Libro(String titulo, String autor, String isbn, boolean disponible) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.disponible = disponible;
    }

    public Long getId() {
        return this.id;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public String getAutor() {
        return this.autor;
    }

    public String getIsbn() {
        return this.isbn;
    }

    public boolean isDisponible() {
        return this.disponible;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Libro)) return false;
        Libro libro = (Libro) o;
        return disponible == libro.disponible && 
               Objects.equals(this.id, libro.id) && 
               Objects.equals(this.titulo, libro.titulo) &&
               Objects.equals(this.autor, libro.autor) &&
               Objects.equals(this.isbn, libro.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.titulo, this.autor, this.isbn, this.disponible);
    }

    @Override
    public String toString() {
        return "Libro{" + "id=" + this.id + 
               ", titulo='" + this.titulo + '\'' + 
               ", autor='" + this.autor + '\'' + 
               ", isbn='" + this.isbn + '\'' + 
               ", disponible=" + this.disponible + '}';
    }
}





















