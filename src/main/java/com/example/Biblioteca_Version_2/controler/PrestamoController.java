package com.example.Biblioteca_Version_2.controler;

import com.example.Biblioteca_Version_2.entities.Libros;
import com.example.Biblioteca_Version_2.entities.Prestamo;
import com.example.Biblioteca_Version_2.entities.Socios;
import com.example.Biblioteca_Version_2.repositories.LibrosRepositories;
import com.example.Biblioteca_Version_2.repositories.PrestamoRepositories;
import com.example.Biblioteca_Version_2.repositories.SociosRepositories;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
public class PrestamoController {

    private final SociosRepositories sociosRepositories;
    private final LibrosRepositories librosRepositories;
    private final PrestamoRepositories prestamoRepositories;

    // anotación que mapea las peticiones GET a la URL "/alquiler"
    @GetMapping("/prestamo")
    public String findAll(Model model) {
        log.info("Buscar todos los prestamos para la vista");

        // obtener todos los prestamos de la base de datos
        List<Prestamo> prestamos = prestamoRepositories.findAll();
        List<Libros> libros = librosRepositories.findAll();
        List<Socios> socios = sociosRepositories.findAll();

        // pasar datos a la vista
        model.addAttribute("prestamos", prestamos);
        model.addAttribute("libros", libros);
        model.addAttribute("socios", socios);

        return "prestamo/prestamo-list";
    }
}
