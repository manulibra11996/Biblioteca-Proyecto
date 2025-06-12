package com.example.Biblioteca_Version_2.entidades;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Setter;

import com.example.Biblioteca_Version_2.entidades.Autor;

import java.util.Date;


// Entidad Autor
@Builder
@Entity
@Table(name = "autores")
public class Autor {
    @lombok.Setter
    @lombok.Getter
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "biografia")
    private String biografia;
    @Setter
    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;
    @Column(name = "nacionalidad")
    private String nacionalidad;

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

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
}
