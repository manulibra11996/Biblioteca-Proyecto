package com.example.Biblioteca_Version_2.controler;

import com.example.Biblioteca_Version_2.repositories.PrestamoRepositories;
import org.springframework.stereotype.Controller;

@Controller
public class PrestamoController {
    private PrestamoRepositories prestamoRepositories;

    public PrestamoController(PrestamoRepositories prestamoRepositories) {
        this.prestamoRepositories = prestamoRepositories;
    }

    // anotación que mapea las peticiones GET a la URL "/alquiler"

}
