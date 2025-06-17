package com.example.Biblioteca_Version_2.entidades;

import jakarta.persistence.*;
import lombok.NonNull;

import java.util.Date;

@Entity // indica que esta clase es una tabla
@Table(name = "prestamo") // personaliza el nombre de la tabla
public class Prestamo {

    @Id // indica que este atributo es la clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //MUCHOS Prestamos pertenece a UN socio
    @OneToMany
    @JoinColumn(name = "socio_id")
    private Socios socio;//Modificar por el tipo Socio

    //MUCHOS Prestamos pertenece a UN libro
    @OneToMany
    @JoinColumn(name = "libro_id")
    private Libros libro;//Modificar por el tipo Libro

    @Column(nullable = false)
    private Date fechaEntrega;

    private Date fechaDevolucion;

    // constructor vacío
    public Prestamo() {
    }

    // constructor con parámetros
    public Prestamo(Socios socio, Libros libro, Date fechaEntrega, Date fechaDevolucion) {
        this.socio = socio;
        this.libro = libro;
        this.fechaEntrega = fechaEntrega;
        this.fechaDevolucion = fechaDevolucion;
    }

    // getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Socios getSocio() {
        return socio;
    }

    public void setSocio(Socios socio) {
        this.socio = socio;
    }

    public Libros getLibro() {
        return libro;
    }

    public void setLibro(Libros libro) {
        this.libro = libro;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
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