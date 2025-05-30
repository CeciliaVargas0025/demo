package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(LibroRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Libro("The Lord of the Rings", "J.R.R. Tolkien", "978-0544003415", true)));
            log.info("Preloading " + repository.save(new Libro("Harry Potter and the Philosopher's Stone", "J.K. Rowling", "978-0747532743", true)));
        };
    }
}  