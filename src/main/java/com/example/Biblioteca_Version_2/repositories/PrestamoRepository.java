package com.example.Biblioteca_Version_2.repositories;

import com.example.Biblioteca_Version_2.entities.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrestamoRepository extends JpaRepository<Prestamo, Long> {

    // prestamos de 1 semana

    long countByLibro_Id(Long id);

    long countBySocio_Id(Long id);


}
