package com.example.Biblioteca_Version_2.controler;

import com.example.Biblioteca_Version_2.repositories.PrestamoRepositories;
import com.example.Biblioteca_Version_2.repositories.SociosRepositories;
import org.springframework.stereotype.Controller;

@Controller
public class SociosControllers {
    private SociosRepositories sociosRepositories;

    public SociosControllers(SociosRepositories sociosRepositories) {
        this.sociosRepositories = sociosRepositories;
    }

    // anotación que mapea las peticiones GET a la URL "/alquiler"

}
