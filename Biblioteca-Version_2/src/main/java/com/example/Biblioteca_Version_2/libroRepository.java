package com.adecco.biblioteca.Proyecto_final;

import com.adecco.entities.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@SpringBootApplication 
public class LibroRepository {

public static void main(String[] args) {

// Inicializar Spring

ApplicationContext spring = SpringApplication.run(LibroRepository.class, args);


public interface LibroRepository extends JpaRepository <Libro, Long> {


List<libro> findbyTitulo (String titulo);
List<libro> findbyAutor (String autor);
List<libro> findbyNumeropaginas (Double numeropaginas);
List<libro> findbyDisponible (Boolean disponible);

}


// Obtener repositorio
LibroRepository libroRepository = spring.getBean(libroRepository.class);

// Crear libros

Libro libro1 = new Libro(titulo= "Los Pilares de la Tierrra", autor= "Ken Follett", numeroPaginas= 150, disponible= false);
Libro libro2 = new Libro(titulo= "Crónica de una muerte anunciada", autor= "Gabriel Garcia Marquez", numeroPaginas= 150, disponible= true);
Libro libro3 = new Libro(titulo= "Los Cachorros", autor= "Mario Vargas Llosa", numeroPaginas= 150, disponible= true);

// Guardar libros

libroRepository.saveAll(List.of(libro1, libro2, libro3));



}

}