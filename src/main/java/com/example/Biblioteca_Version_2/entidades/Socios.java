package com.example.Biblioteca_Version_2.entidades;

import jakarta.persistence.*;
import lombok.Data;

@Entity // indica que esta clase es una tabla
@Table(name = "socios") // personaliza el nombre de la tabla
public class Socios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;// columna nombre

    @Column(nullable = false)
    private String direccion; // columna direccion

    @Column(nullable = false)
    private String telefono; // columna telefono

    @Column(nullable = false)
    private String email; // columna email

    public Socios() {
    }

    public Socios(String nombre, String direccion, String telefono, String email) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }

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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
