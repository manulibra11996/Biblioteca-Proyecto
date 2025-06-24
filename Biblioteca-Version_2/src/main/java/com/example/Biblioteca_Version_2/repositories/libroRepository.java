package com.example.Biblioteca_Version_2.repositories;

import com.adecco.entities.Libro;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@SpringBootApplication
public class LibroRepository {

    public static void main(String[] args) {

// Inicializar Spring



        public interface LibroRepository extends JpaRepository<Libro, Long> {
        }

    }

}