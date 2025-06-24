package com.example.Biblioteca_Version_2.controler;

import com.example.Biblioteca_Version_2.entities.Autor;
import com.example.Biblioteca_Version_2.entities.Categorias;
import com.example.Biblioteca_Version_2.repositories.AutorRepository;
import com.example.Biblioteca_Version_2.repositories.CategoriasRepositories;
import com.example.Biblioteca_Version_2.repositories.SociosRepositories;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Controller
public class AutorController {

    private final AutorRepository autorRepository;


    @GetMapping("/autor") // http://localhost:8080/productos
    public String findAll(Model model) {

        List<Autor> autor = autorRepository.findAll();
        model.addAttribute("autor", autor);

        return "autor/autor-list";
    }

    @GetMapping("/autor/{id}") // http://localhost:8080/productos/1
    public String findById(Model model, @PathVariable Long id) {
        Optional<Autor> autorOpt = autorRepository.findById(id);

        if (autorOpt.isPresent()) {
            model.addAttribute("autor", autorOpt.get());
        } else {
            model.addAttribute("error", "404 Autor Not Found");
        }

        return "autor/autor-detail";
    }

    /*
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
}// Rutas para Autor
@GetMapping("/autores/eliminar/{id}")
public String eliminarAutor(@PathVariable Long id) {
    autorService.eliminarAutor(id);
    return "redirect:/autores";
}


*/
}
