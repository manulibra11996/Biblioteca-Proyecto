package com.example.Biblioteca_Version_2.repositories;

import com.example.Biblioteca_Version_2.entities.Autor;
import com.example.Biblioteca_Version_2.entities.Libros;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LibrosRepositories extends JpaRepository<Libros, Long> {


    List<Libros> findByTitulo(String titulo);

    List<Libros> findByAutor(Autor autor);

    List<Libros> findByNumeroPaginas(Double numeroPaginas);

    List<Libros> findByDisponible(Boolean disponible);


}
