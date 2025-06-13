package com.example.Biblioteca_Version_2.controler;

import com.example.Biblioteca_Version_2.entidades.Autor;
import com.example.Biblioteca_Version_2.repositories.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class AutorControllers {


    // Controlador de Autor
    @RestController
    @RequestMapping("/api/autores")
    public class AutorController {
        @Autowired
        private AutorRepository.AutorService autorService;

        // Obtener todos los autores
        @GetMapping
        public ResponseEntity<List<Autor>> getAllAutores() {
            List<Autor> autores = autorService.getAllAutores();
            return new ResponseEntity<>(autores, HttpStatus.OK);
        }

        // Obtener un autor por ID
        @GetMapping("/{id}")
        public ResponseEntity<Autor> getAutorById(@PathVariable Long id) {
            Autor autor = autorService.getAutorById(id);
            if (autor != null) {
                return new ResponseEntity<>(autor, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }

        // Crear un nuevo autor
        @PostMapping
        public ResponseEntity<Autor> createAutor(@RequestBody Autor autor) {
            Autor nuevoAutor = autorService.saveAutor(autor);
            return new ResponseEntity<>(nuevoAutor, HttpStatus.CREATED);
        }

        // Actualizar un autor existente
        @PutMapping("/{id}")
        public ResponseEntity<Autor> updateAutor(@PathVariable Long id, @RequestBody Autor autor) {
            Autor autorExistente = autorService.getAutorById(id);
            if (autorExistente != null) {
                autorExistente.setNombre(autor.getNombre());
                autorExistente.setApellido(autor.getApellido());
                autorExistente.setBiografia(autor.getBiografia());
                autorExistente.setFechaNacimiento(autor.getFechaNacimiento());
                autorExistente.setNacionalidad(autor.getNacionalidad());
                Autor autorActualizado = autorService.saveAutor(autorExistente);
                return new ResponseEntity<>(autorActualizado, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }

        // Eliminar un autor
        @DeleteMapping("/{id}")
        public ResponseEntity<HttpStatus> deleteAutor(@PathVariable Long id) {
            autorService.deleteAutor(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        // Buscar autores por nombre
        @GetMapping("/search/nombre/{nombre}")
        public ResponseEntity<List<Autor>> searchAutoresByNombre(@PathVariable String nombre) {
            List<Autor> autores = autorService.searchAutoresByNombre(nombre);
            return new ResponseEntity<>(autores, HttpStatus.OK);
        }

        // Buscar autores por apellido
        @GetMapping("/search/apellido/{apellido}")
        public ResponseEntity<List<Autor>> searchAutoresByApellido(@PathVariable String apellido) {
            List<Autor> autores = autorService.searchAutoresByApellido(apellido);
            return new ResponseEntity<>(autores, HttpStatus.OK);
        }
    }


}
