package com.example.Biblioteca_Version_2.entities;

import jakarta.persistence.*;
import java.util.Date;


// Entidad Autor
@Entity
@Table(name = "autores")
public class Autor {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "biografia")
    private String biografia;

    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;
    @Column(name = "nacionalidad")
    private String nacionalidad;

    public Autor() {
    }

    public Autor(String nombre, String apellido, String biografia, Date fechaNacimiento, String nacionalidad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.biografia = biografia;
        this.fechaNacimiento = fechaNacimiento;
        this.nacionalidad = nacionalidad;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
}
