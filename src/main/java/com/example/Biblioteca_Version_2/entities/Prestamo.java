package com.example.Biblioteca_Version_2.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.util.Date;

@Getter
@Setter
@Entity // indica que esta clase es una tabla
@Table(name = "prestamo") // personaliza el nombre de la tabla
public class Prestamo {

    // getters y setters
    @Id // indica que este atributo es la clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //MUCHOS Prestamos pertenece a UN socio
    @ManyToOne
    @JoinColumn(name = "socio_id")
    private Socios socio;//Modificar por el tipo Socio

    //MUCHOS Prestamos pertenece a UN libro
    @ManyToOne
    @JoinColumn(name = "libro_id")
    private Libros libro;//Modificar por el tipo Libro

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date fechaEntrega;

    @Temporal(TemporalType.DATE)
    private Date fechaDevolucion;

    // constructor vacío
    public Prestamo() {
    }

    public Prestamo(Socios socio, Libros libro, Date fechaEntrega, Date fechaDevolucion) {
        this.socio = socio;
        this.libro = libro;
        this.fechaEntrega = fechaEntrega;
        this.fechaDevolucion = fechaDevolucion;
    }

    @Override
    public String toString() {
        return "Prestamo{" +
                "id=" + id +
                ", socio='" + socio + '\'' +
                ", libro='" + libro + '\'' +
                ", fechaEntrega=" + fechaEntrega +
                ", fechaDevolucion=" + fechaDevolucion +
                '}';
    }
}