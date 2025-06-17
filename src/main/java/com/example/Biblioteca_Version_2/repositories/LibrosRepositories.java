package com.example.Biblioteca_Version_2.repositories;

import com.example.Biblioteca_Version_2.entities.Libros;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LibrosRepositories extends JpaRepository<Libros, Long> {


    List<Libros> findbyTitulo(String titulo);

    List<Libros> findbyAutor(String autor);

    List<Libros> findbyNumeropaginas(Double numeropaginas);

    List<Libros> findbyDisponible(Boolean disponible);


}
