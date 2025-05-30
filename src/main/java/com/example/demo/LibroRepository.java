package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

interface LibroRepository extends JpaRepository<Libro, Long> {
}