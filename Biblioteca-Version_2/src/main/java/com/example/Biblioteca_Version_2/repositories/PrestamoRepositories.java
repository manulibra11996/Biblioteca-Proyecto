package com.example.Biblioteca_Version_2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PrestamoRepositories extends JpaRepository<Prestamo, Long> {

    // spring boot implementa métodos básicos:
    // findAll(), findById(), save(), delete(), etc...

    // métodos derivados
    // Busqueda por usuario

    //Busqueda por libro

    //Busqueda de libros no devueltos

    //Busqueda de libros devueltos

    //Libros sacados desde 2 fechas

    //Libros devueltos desde 2 fechas
}

