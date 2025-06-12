package com.example.Biblioteca_Version_2.entidades;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    // Servicio de Autor
    @Service
    public class AutorService {
        @Autowired
        private AutorRepository autorRepository;

        public List<Autor> getAllAutores() {
            return autorRepository.findAll();
        }

        public Autor getAutorById(Long id) {
            return autorRepository.findById(id).orElse(null);
        }

        public Autor saveAutor(Autor autor) {
            return autorRepository.save(autor);
        }

        public void deleteAutor(Long id) {
            autorRepository.deleteById(id);
        }

        public List<Autor> searchAutoresByNombre(String nombre) {
            return autorRepository.findByNombreContaining(nombre);
        }

        public List<Autor> searchAutoresByApellido(String apellido) {
            return autorRepository.findByApellidoContaining(apellido);
        }
    }

    List<Autor> findByApellidoContaining(String apellido);

    List<Autor> findByNombreContaining(String nombre);


}