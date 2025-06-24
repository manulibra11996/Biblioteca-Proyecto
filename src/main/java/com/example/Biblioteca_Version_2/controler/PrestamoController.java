package com.example.Biblioteca_Version_2.controler;

import com.example.Biblioteca_Version_2.entities.Libro;
import com.example.Biblioteca_Version_2.entities.Prestamo;
import com.example.Biblioteca_Version_2.entities.Socio;
import com.example.Biblioteca_Version_2.repositories.LibroRepository;
import com.example.Biblioteca_Version_2.repositories.PrestamoRepository;
import com.example.Biblioteca_Version_2.repositories.SocioRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Controller
public class PrestamoController {

    private final SocioRepository socioRepository;
    private final LibroRepository libroRepository;
    private final PrestamoRepository prestamoRepository;

    // anotación que mapea las peticiones GET a la URL "/alquiler"
    @GetMapping("/prestamo")
    public String findAll(Model model) {
        log.info("Buscar todos los prestamos para la vista");

        // obtener todos los prestamos de la base de datos
        List<Prestamo> prestamos = prestamoRepository.findAll();
        List<Libro> libros = libroRepository.findAll();
        List<Socio> socios = socioRepository.findAll();

        // pasar datos a la vista
        model.addAttribute("prestamos", prestamos);
        model.addAttribute("libros", libros);
        model.addAttribute("socios", socios);

        return "prestamo/prestamo-list";
    }

    // detalle de prestamo
    @GetMapping("/prestamo/{id}")
    public String findById(Model model, @PathVariable Long id) {
        Optional<Prestamo> prestamoOpt = prestamoRepository.findById(id);

        if (prestamoOpt.isPresent()) {
            model.addAttribute("prestamo", prestamoOpt.get());
        } else {
            model.addAttribute("error", "No se ha encontrado el prestamo");
        }

        return "prestamo/prestamo-detail"; // TODO: crear proveedor-detail.html
    }

    // mostrar formulario para crear nuevo prestamo
    @GetMapping("/prestamo/nuevo")
    public String createForm(Model model) {
        model.addAttribute("prestamo", new Prestamo());
        model.addAttribute("libro", libroRepository.findAll());
        model.addAttribute("socio", socioRepository.findAll());

        return "prestamo/prestamo-form";
    }

    // mostrar formulario para editar prestamo existente
    @GetMapping("/prestamo/{id}/editar")
    public String editForm(Model model, @PathVariable Long id) {
        Optional<Prestamo> prestamoOpt = prestamoRepository.findById(id);

        if (prestamoOpt.isPresent()) {
            model.addAttribute("prestamo", prestamoOpt.get());
            model.addAttribute("libro", libroRepository.findAll());
            model.addAttribute("socio", socioRepository.findAll());
        } else {
            model.addAttribute("error", "Prestamo no encontrado");
        }

        return "prestamo/prestamo-form";
    }

    // procesar formulario (crear o actualizar)
    @PostMapping("/prestamo")
    public String saveForm(@ModelAttribute Prestamo prestamo) {
        prestamoRepository.save(prestamo);
        return "redirect:/prestamo";
    }

    @PostMapping("/prestamo/{id}/eliminar")
    public String delete(@PathVariable Long id) {

        prestamoRepository.deleteById(id);

        return "redirect:/prestamo";
    }
}
