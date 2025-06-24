package com.example.Biblioteca_Version_2.repositories;

import com.example.Biblioteca_Version_2.entities.Autor;
import com.example.Biblioteca_Version_2.entities.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LibroRepository extends JpaRepository<Libro, Long> {


    List<Libro> findByTitulo(String titulo);

    List<Libro> findByAutor(Autor autor);

    List<Libro> findByNumeroPaginas(Double numeroPaginas);

    List<Libro> findByDisponible(Boolean disponible);

    long countByAutor_Id(Long id);

    long countByCategoria_Id(Long id);


}
