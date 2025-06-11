package com.adecco.biblioteca.Proyecto_final;

import com.certidevs.entities.Libro;
import com.certidevs.repositories.CategoriaRepository;
import com.certidevs.repositories.libroRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/libros")
public class LibroController {

    @Autowired
    private libroRepository libroRepository;
    private CategoriaRepository categoriaRepository;

    @GetMapping
    public List<Libro> getAllLibros() {

        return libroRepository.findAll();

    }

    public LibroController(libroRepository libroRepository, CategoriaRepository categoriaRepository) {
        this.productoRepository = productoRepository;
        this.categoriaRepository = categoriaRepository;
    }

    @GetMapping("/libro") // http://localhost:8080/productos
    public String findAll(Model model) {
        
        List<Libro> libros = libroRepository.findAll();
        model.addAttribute("libro", libros);

        return "libro-list";
    }

    @GetMapping("/libros/{id}") // http://localhost:8080/productos/1
    public String findById(Model model, @PathVariable Long id) {
        Optional<Libro> libroOpt = libroRepository.findById(id);

        if (libroOpt.isPresent()) {
           model.addAttribute("libro", productoOpt.get());
        } else {
            model.addAttribute("error", "404 Producto Not Found");
        }

        return "producto-detail";
    }

    @GetMapping("/libros/nuevo")
    public String createForm(Model model) {
        model.addAttribute("libro", new Libro());
        model.addAttribute("categorias", categoriaRepository.findAll());

        return "libro-form";
    }

    
    @GetMapping("/libros/{id}/editar")
    public String editForm(Model model, @PathVariable Long id) {
        Optional<Libro> libroOpt = libroRepository.findById(id);

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
        productoRepository.save(libro);

        return "redirect:/libros";
    }

    
    @PostMapping("/libros/{id}/eliminar")
    public String delete(@PathVariable Long id) {
        librosRepository.deleteById(id);

        return "redirect:/libros";
    }
}
