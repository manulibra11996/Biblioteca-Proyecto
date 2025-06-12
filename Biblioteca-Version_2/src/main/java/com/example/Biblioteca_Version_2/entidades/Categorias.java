package com.example.Biblioteca_Version_2.entidades;

import jakarta.persistence.*;

@Entity // indica que esta clase es una tabla
@Table(name = "Categorias") // personaliza el nombre de la tabla

public class Categorias {

    @Id // indica que este atributo es la clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;

    // Constructor
    public Categorias () {}
    public Categorias(Long id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    // Método para mostrar la información de la categoría
    @Override
    public String toString() {
        return "Categoría: " + nombre + " (ID: " + id + "), " + descripcion;
    }

    public Categorias(Categorias categoria) {
    }
}
