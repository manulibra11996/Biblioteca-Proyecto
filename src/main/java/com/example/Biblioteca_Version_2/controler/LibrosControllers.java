package com.example.Biblioteca_Version_2.controler;

import org.springframework.ui.Model;
import com.example.Biblioteca_Version_2.entidades.Libros;
import com.example.Biblioteca_Version_2.repositories.CategoriasRepositories;
import com.example.Biblioteca_Version_2.repositories.LibrosRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/libros")
public class LibrosControllers {

    @Autowired
    private LibrosRepositories libroRepository;
    private CategoriasRepositories categoriaRepository;

    @GetMapping
    public List<Libros> getAllLibros() {

        return libroRepository.findAll();

    }

    public LibrosControllers(LibrosRepositories libroRepository, CategoriasRepositories categoriaRepository) {
        this.libroRepository = libroRepository;
        this.categoriaRepository = categoriaRepository;
    }

    @GetMapping("/libro") // http://localhost:8080/productos
    public String findAll(Model model) {

        List<Libros> libros = libroRepository.findAll();
        model.addAttribute("libro", libros);

        return "libro-list";
    }

    @GetMapping("/libros/{id}") // http://localhost:8080/productos/1
    public String findById(Model model, @PathVariable Long id) {
        Optional<Libros> libroOpt = libroRepository.findById(id);

        if (libroOpt.isPresent()) {
            model.addAttribute("libro", libroOpt.get());
        } else {
            model.addAttribute("error", "404 Producto Not Found");
        }

        return "producto-detail";
    }

    @GetMapping("/libros/nuevo")
    public String createForm(Model model) {
        model.addAttribute("libro", new Libros());
        model.addAttribute("categorias", categoriaRepository.findAll());

        return "libro-form";
    }


    @GetMapping("/libros/{id}/editar")
    public String editForm(Model model, @PathVariable Long id) {
        Optional<Libros> libroOpt = libroRepository.findById(id);

        if (libroOpt.isPresent()) {
            model.addAttribute("libro", libroOpt.get());
            model.addAttribute("categorias", categoriaRepository.findAll());
        } else {
            model.addAttribute("error", "Libro no encontrado");
        }

        return "libro-form";
    }


    @PostMapping("/libros") // podría ser @PostMapping("/libros/form") si en el formulario pusiera th:action="@{/libros/form}"
    public String saveForm(@ModelAttribute Libro libro) {
        libroRepository.save(libro);

        return "redirect:/libros";
    }


    //@PostMapping("/libros/{id}/eliminar")
    //public String delete(@PathVariable Long id) {
     //   LibrosRepositories.deleteById(id);

       // return "redirect:/libros";
   // }
}
