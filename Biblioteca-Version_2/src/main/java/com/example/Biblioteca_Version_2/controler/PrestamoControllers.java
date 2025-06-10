package com.example.Biblioteca_Version_2.controler;

import com.example.Biblioteca_Version_2.repositories.PrestamoRepositories;
import org.springframework.stereotype.Controller;

@Controller
public class PrestamoControllers {
    private PrestamoRepositories prestamoRepositories;

    public PrestamoControllers(PrestamoRepositories prestamoRepositories) {
        this.prestamoRepositories = prestamoRepositories;
    }
}
